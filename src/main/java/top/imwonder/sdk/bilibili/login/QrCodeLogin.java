/*
 * @Author: Wonder2019
 * @Date: 2020-09-06 14:20:30
 * @Last Modified by: Wonder2019
 * @Last Modified time: 2020-09-06 14:53:23
 */
package top.imwonder.sdk.bilibili.login;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import com.google.zxing.WriterException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import top.imwonder.sdk.bilibili.domain.AbstractPassport;
import top.imwonder.sdk.bilibili.enumeration.QrCodeStatus;
import top.imwonder.sdk.bilibili.exception.BadResultException;
import top.imwonder.sdk.bilibili.exception.HttpRequestFailedException;
import top.imwonder.sdk.bilibili.util.HttpRequestUtil;
import top.imwonder.sdk.bilibili.util.QrCodeUtil;
import top.imwonder.util.MessageUtil;

/**
 * 二维码登录接口，已实现 {@link Runnable Runnable}
 * 接口，可以在单独线程中自动处理二维码登录的事务。同时也提供了在当前线程中自动处理二维码登录的方法。
 */
@Slf4j
@Getter
public final class QrCodeLogin<T extends AbstractPassport> extends AbstractLogin<T> implements Runnable {

    /** 获取二维码API */
    public final static String GET_QR_CODE_URL = "https://passport.bilibili.com/qrcode/getLoginUrl";

    /** 二维码认证API */
    public final static String AUTH_QR_CODE_URL = "https://passport.bilibili.com/qrcode/getLoginInfo";

    /** 自动二维码登录事务 */
    @Setter
    private QrCodeLoginTask<T> qrLoginTask;

    /** 二维码大小，默认 300px */
    @Setter
    private int qrCodeSize = 300;

    /** 二维码状态 */
    private QrCodeStatus state;

    /** 二维码创建时间 */
    private long timestemp;

    /** 二维码扫描时间 */
    private long scanTime;

    /** 二维码文本 */
    private String loginPath;

    /** 二维码通信密钥 */
    private String oauthKey;

    /** 二维码图片 */
    private BufferedImage qrCode;

    public QrCodeLogin(T bilibiliAuth){
        super(bilibiliAuth);
    }

    /**
     * 获取登录二维码
     *
     * @return 二维码图片
     * @throws HttpRequestFailedException
     * @throws BadResultException
     * @throws WriterException
     */
    public BufferedImage loginForImage() throws HttpRequestFailedException, BadResultException, WriterException {
        return QrCodeUtil.createQrCode(loginForPath(), qrCodeSize);
    }

    /**
     * 获取二维码内容
     *
     * @return 二维码内容
     * @throws HttpRequestFailedException
     * @throws BadResultException
     */
    public String loginForPath() throws HttpRequestFailedException, BadResultException {
        HttpGet get = new HttpGet(GET_QR_CODE_URL);
        HttpRequestUtil.setComonHeader(get);
        try (CloseableHttpResponse res = httpClient.execute(get)) {
            Map<String, Object> result = HttpRequestUtil.toResultMap(res);
            if ((Double) result.get("code") != 0) {
                throw new BadResultException((String) result.get("message"));
            }
            timestemp = (long) (double) result.get("ts");
            @SuppressWarnings("unchecked")
            Map<String, String> data = (Map<String, String>) (result.get("data"));
            loginPath = data.get("url");
            oauthKey = data.get("oauthKey");
            return loginPath;
        } catch (ClientProtocolException e) {
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new HttpRequestFailedException(MessageUtil.getMsg("login.qrcode.error.getfailed"));
    }

    public QrCodeStatus refreshStatus() throws HttpRequestFailedException, BadResultException {
        if (oauthKey == null) {
            throw new HttpRequestFailedException(MessageUtil.getMsg("login.qrcode.error.noqrcode"));
        }
        URIBuilder uri = new URIBuilder();
        uri.setPath(AUTH_QR_CODE_URL);
        uri.setParameter("oauthKey", oauthKey);
        HttpPost post = null;
        try {
            post = new HttpPost(uri.build());
        } catch (URISyntaxException e) {
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
        }
        HttpRequestUtil.setComonHeader(post);
        try (CloseableHttpResponse res = httpClient.execute(post)) {
            Map<String, Object> result = HttpRequestUtil.toResultMap(res);
            Double code = (Double) result.get("code");
            if ((code != null && code != 0) || result.get("data") == null) {
                throw new BadResultException((String) result.get("message"));
            }
            scanTime = (long) (result.get("ts") == null ? 0 : (double) result.get("ts"));
            Object data = result.get("data");
            if (data instanceof Number) {
                state = QrCodeStatus.query((Double) data);
            } else if (data instanceof Map) {
                Header headers[] = res.getHeaders("Set-Cookie");
                bilibiliAuth.success(headers);
                state = QrCodeStatus.SUCCESS;
            }
            return state;
        } catch (ClientProtocolException e) {
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new HttpRequestFailedException(MessageUtil.getMsg("login.qrcode.error.checkfailed"));
    }

    /**
     * 以多线程的形式自动处理二维码登录，需要先设置 ‘qrLoginTask’ 参数以供回调。若未设置，将不会进行任何操作直接结束线程。
     */
    @Override
    public void run() {
        syncAutoCheck(qrLoginTask);
    }

    /**
     * 以单线程的形式自动处理二维码登录，传入{@link top.imwonder.sdk.bilibili.login.QrCodeLoginTask
     * QrCodeLoginTask} 以供回调。若未设置，将不会进行任何操作。
     *
     * @param task 二维码登录任务 {@link top.imwonder.sdk.bilibili.login.QrCodeLoginTask
     *             QrCodeLoginTask}
     */
    public T syncAutoCheck(QrCodeLoginTask<T> task) {
        return syncAutoCheck(task, 3000);
    }

    /**
     * 以单线程的形式自动处理二维码登录，传入{@link top.imwonder.sdk.bilibili.login.QrCodeLoginTask
     * QrCodeLoginTask} 以供回调。若未设置，将不会进行任何操作。
     *
     * @param task 二维码登录任务 {@link top.imwonder.sdk.bilibili.login.QrCodeLoginTask
     *             QrCodeLoginTask}
     * @param freq 检查二维码状态的频率，单位为 ms。
     */
    public T syncAutoCheck(QrCodeLoginTask<T> task, long freq) {
        if (task == null) {
            log.warn(MessageUtil.getMsg("login.qrcode.warn.notask"));
            return null;
        }
        while (true) {
            try {
                task.ready(loginForImage());
                while (refreshStatus() != QrCodeStatus.SUCCESS) {
                    try {
                        Thread.sleep(freq);
                    } catch (Exception e) {
                        log.info(MessageUtil.getMsg("error.unexpected"));
                        log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
                    }
                    if (state == QrCodeStatus.WAITING_FOR_CONFIRM) {
                        task.scanned();
                    }
                }
                task.success(bilibiliAuth);
                break;
            } catch (WriterException e) {
                log.info(MessageUtil.getMsg("error.unexpected"));
                log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
                task.onError(e);
                break;
            }
        }
        return bilibiliAuth;
    }

}
