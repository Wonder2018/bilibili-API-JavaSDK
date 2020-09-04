package top.imwonder.sdk.bilibili.login;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import com.google.zxing.WriterException;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.utils.URIBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import top.imwonder.sdk.bilibili.domain.User;
import top.imwonder.sdk.bilibili.enumeration.QrCodeStatus;
import top.imwonder.sdk.bilibili.exception.BadResultException;
import top.imwonder.sdk.bilibili.exception.HttpRequestFailedException;
import top.imwonder.sdk.bilibili.util.HttpRequestUtil;
import top.imwonder.sdk.bilibili.util.QrCodeUtil;

/**
 * 二维码登录接口，已实现 {@link Runnable Runnable}
 * 接口，可以在单独线程中自动处理二维码登录的事务。同时也提供了在当前线程中自动处理二维码登录的方法。
 */
@Slf4j
@Getter
@Setter
public final class QrCodeLogin implements Runnable {

    /** 获取二维码API */
    public final static String GET_QR_CODE_URL = "https://passport.bilibili.com/qrcode/getLoginUrl";

    /** 二维码认证API */
    public final static String AUTH_QR_CODE_URL = "http://passport.bilibili.com/qrcode/getLoginInfo";

    /** 自动二维码登录事务 */
    private QrCodeLoginTask qrLoginTask;

    /** 二维码大小，默认 300px */
    private int qrCodeSize = 300;

    /** 二维码状态 */
    private QrCodeStatus status;

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

    /** 登录成功的用户 */
    private User user;

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
        try (CloseableHttpResponse res = HttpRequestUtil.doGet(GET_QR_CODE_URL, null, false)) {
            Map<String, Object> result = HttpRequestUtil.toResultMap(res);
            if ((double) result.get("code") != 0) {
                throw new BadResultException((String) result.get("message"));
            }
            timestemp = (long) (double) result.get("ts");
            @SuppressWarnings("unchecked")
            Map<String, String> data = (Map<String, String>) (result.get("data"));
            loginPath = data.get("url");
            oauthKey = data.get("oauthKey");
            return loginPath;
        } catch (ClientProtocolException e) {
            log.info("May not Happen（；´д｀）ゞ");
            log.debug("Something may helpful: {}", e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        throw new HttpRequestFailedException(
                "Failed to generate Qr code, more information will be output in debug mode!");
    }

    private QrCodeStatus refreshStatus() throws HttpRequestFailedException, BadResultException {
        URIBuilder uri = new URIBuilder();
        uri.setPath(AUTH_QR_CODE_URL);
        uri.setParameter("oauthKey", oauthKey);
        try (CloseableHttpResponse res = HttpRequestUtil.doPost(uri.build(), false)) {
            Map<String, Object> result = HttpRequestUtil.toResultMap(res);
            Double code = (Double) result.get("code");
            if ((code != null && code != 0) || result.get("data") == null) {
                throw new BadResultException((String) result.get("message"));
            }
            scanTime = (long) (result.get("ts") == null ? 0 : (double) result.get("ts"));
            Object data = result.get("data");
            if (data instanceof Number) {
                status = QrCodeStatus.query((Double) data);
            } else if (data instanceof Map) {
                Header headers[] = res.getHeaders("Set-Cookie");
                for (Header header : headers) {
                    HeaderElement firstElement = header.getElements()[0];
                    switch (firstElement.getName()) {
                        // TODO fix cookies order!
                        case "DedeUserID":
                            user = new User(firstElement.getValue());
                            break;
                        case "DedeUserID__ckMd5":
                            user.setUidCheckMD5(firstElement.getValue());
                            break;
                        case "SESSDATA":
                            user.setSessdata(firstElement.getValue());
                            break;
                        case "bili_jct":
                            user.setCsrfToken(firstElement.getValue());
                            break;
                        default:
                            break;
                    }
                }
                // CookieStore cs = new Cookies
                status = QrCodeStatus.SUCCESS;
            }
            return status;
        } catch (ClientProtocolException e) {
            log.info("May not Happen（；´д｀）ゞ");
            log.debug("Something may helpful: {}", e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        throw new HttpRequestFailedException(
                "Failed to check Qr code status, more information will be output in debug mode!");
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
    public void syncAutoCheck(QrCodeLoginTask task) {
        syncAutoCheck(task, 3000);
    }

    /**
     * 以单线程的形式自动处理二维码登录，传入{@link top.imwonder.sdk.bilibili.login.QrCodeLoginTask
     * QrCodeLoginTask} 以供回调。若未设置，将不会进行任何操作。
     *
     * @param task 二维码登录任务 {@link top.imwonder.sdk.bilibili.login.QrCodeLoginTask
     *             QrCodeLoginTask}
     * @param freq 检查二维码状态的频率，单位为 ms。
     */
    public void syncAutoCheck(QrCodeLoginTask task, long freq) {
        if (task == null) {
            log.warn("Parameter 'qrLoginTask' is not set, no operation will be performed.");
            return;
        }
        while (true) {
            try {
                task.ready(loginForImage());
                while (refreshStatus() != QrCodeStatus.SUCCESS) {
                    try {
                        Thread.sleep(freq);
                    } catch (Exception e) {
                        log.info("May not Happen（；´д｀）ゞ");
                        log.debug("Something may helpful: {}", e.getMessage());
                    }
                    if (status == QrCodeStatus.WAITING_FOR_CONFIRM) {
                        task.scanned();
                    }
                }
                task.success(user);
                break;
            } catch (WriterException e) {
                log.info("May not Happen（；´д｀）ゞ");
                log.debug("Something may helpful: {}", e.getMessage());
                task.onError(e);
                break;
            }
        }
    }

}
