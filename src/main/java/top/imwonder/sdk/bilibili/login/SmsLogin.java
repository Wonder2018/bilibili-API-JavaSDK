package top.imwonder.sdk.bilibili.login;

import java.net.URISyntaxException;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;

import lombok.extern.slf4j.Slf4j;
import top.imwonder.sdk.bilibili.domain.ApiData;
import top.imwonder.sdk.bilibili.domain.User;
import top.imwonder.sdk.bilibili.domain.geetest.GeeTestRes;
import top.imwonder.sdk.bilibili.domain.smslogin.CountryList;
import top.imwonder.sdk.bilibili.exception.BadResultException;
import top.imwonder.sdk.bilibili.exception.HttpRequestFailedException;
import top.imwonder.sdk.bilibili.util.HttpRequestUtil;
import top.imwonder.util.MessageUtil;

@Slf4j
public class SmsLogin extends AbstractLogin<User> {

    public static final String COUNTRY_LIST_API = "http://passport.bilibili.com/web/generic/country/list";

    public static final String SEND_SMS_API = "http://passport.bilibili.com/web/sms/general/v2/send";

    public static final String LOGIN_RAPID_API = "http://passport.bilibili.com/web/login/rapid";

    public SmsLogin(User bilibiliAuth) {
        super(bilibiliAuth);
    }

    /**
     * 获取国家地区代号列表
     *
     * @return
     */
    public CountryList queryCountryList() {
        try (CloseableHttpResponse res = HttpRequestUtil.doGet(COUNTRY_LIST_API, null, false)) {
            ApiData<CountryList> result = HttpRequestUtil.toApiData(res, new TypeToken<ApiData<CountryList>>() {
            }.getType());
            return result.getData();
        } catch (Exception e) {
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
            throw new HttpRequestFailedException(e.getMessage());
        }
    }

    /**
     * 发送短信验证码
     *
     * @param cid   国家代号
     * @param phone 手机号
     * @param gtr   验证通过的{@link top.imwonder.sdk.bilibili.domain.geetest.GeeTestRes
     *              geetestres} 需自行插入 <code>validate</code> 和 <code>seccode</code>
     * @return 发送成功返回 <code>true</code> 否则返回 <code>false</code>
     */
    public Boolean sendSms(String cid, String phone, GeeTestRes gtr) {
        URIBuilder uri = new URIBuilder();
        uri.setPath(SEND_SMS_API);
        uri.addParameter("tel", phone);
        uri.addParameter("cid", cid);
        uri.addParameter("type", "21");
        uri.addParameter("captchaType", "6");
        uri.addParameter("key", gtr.getKey());
        uri.addParameter("challenge", gtr.getChallenge());
        uri.addParameter("validate", gtr.getValidate());
        uri.addParameter("seccode", String.format("%s|jordan", gtr.getSeccode()));
        try (CloseableHttpResponse res = HttpRequestUtil.doPost(uri.build(), false)) {
            Map<String, Object> result = HttpRequestUtil.toResultMap(res);
            if (0 == (Integer) result.get("code")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 完成登录
     *
     * @param cid     国家代号
     * @param phone   手机号
     * @param smsCode 短信验证码
     * @return 登录成功的 {@link top.imwonder.sdk.bilibili.domain.User User} 也是创建本类实例时使用的
     *         {@link top.imwonder.sdk.bilibili.login.SmsLogin#SmsLogin(User) User}
     */
    public User login(String cid, String phone, String smsCode) {
        URIBuilder uri = new URIBuilder();
        uri.setPath(LOGIN_RAPID_API);
        uri.addParameter("cid", cid);
        uri.addParameter("tel", phone);
        uri.addParameter("smsCode", smsCode);
        HttpPost post = null;
        try {
            post = new HttpPost(uri.build());
        } catch (URISyntaxException e) {
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
            throw new HttpRequestFailedException(e.getMessage());
        }
        HttpRequestUtil.setComonHeader(post);
        try (CloseableHttpResponse res = httpClient.execute(post)) {
            Map<String, Object> result = HttpRequestUtil.toResultMap(res);
            switch ((Integer) result.get("code")) {
                case 0:
                    bilibiliAuth.success(res.getHeaders("Set-Cookie"));
                    break;
                case -400:
                    // TODO error msg
                    throw new HttpRequestFailedException(MessageUtil.getMsg("error.unexpected"));
                case 1006:
                    throw new BadResultException("msg");
                case 1007:
                    throw new BadResultException("msg");
                default:
                    break;
            }
        } catch (Exception e) {
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
            throw new HttpRequestFailedException(e.getMessage());
        }
        return bilibiliAuth;
    }
}
