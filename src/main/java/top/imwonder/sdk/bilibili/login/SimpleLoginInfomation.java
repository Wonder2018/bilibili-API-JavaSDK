package top.imwonder.sdk.bilibili.login;

import java.io.IOException;

import com.google.gson.reflect.TypeToken;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import lombok.extern.slf4j.Slf4j;
import top.imwonder.sdk.bilibili.domain.ApiData;
import top.imwonder.sdk.bilibili.domain.User;
import top.imwonder.sdk.bilibili.exception.HttpRequestFailedException;
import top.imwonder.sdk.bilibili.util.HttpRequestUtil;
import top.imwonder.util.MessageUtil;

@Slf4j
public class SimpleLoginInfomation {

    public static final String FULL_INFO_API = "http://api.bilibili.com/x/web-interface/nav";

    public void loadFullInfo(User user) throws HttpRequestFailedException {
        HttpGet get = new HttpGet(FULL_INFO_API);
        HttpRequestUtil.setComonHeader(get);
        try (CloseableHttpResponse res = user.getClient().execute(get)) {
            ApiData<User> result = HttpRequestUtil.toApiData(res, new TypeToken<ApiData<User>>() {
            }.getType());
            user.copyFrom(result.getData(), false);
        } catch (ClientProtocolException e) {
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
        } catch (IOException e) {
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
        } catch (NullPointerException e) {
            throw new HttpRequestFailedException(MessageUtil.getMsg("login.userinfo.nologin"));
        }
    }
}
