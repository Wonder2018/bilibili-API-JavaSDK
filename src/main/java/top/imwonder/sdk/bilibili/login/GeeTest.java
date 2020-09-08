package top.imwonder.sdk.bilibili.login;

import com.google.gson.reflect.TypeToken;

import org.apache.http.client.methods.CloseableHttpResponse;

import lombok.extern.slf4j.Slf4j;
import top.imwonder.sdk.bilibili.domain.ApiData;
import top.imwonder.sdk.bilibili.domain.geetest.GeeTestRes;
import top.imwonder.sdk.bilibili.exception.HttpRequestFailedException;
import top.imwonder.sdk.bilibili.util.HttpRequestUtil;
import top.imwonder.util.MessageUtil;

@Slf4j
public class GeeTest {
    public static final String READY_URI = "http://passport.bilibili.com/web/captcha/combine?plat=6";

    public GeeTestRes doGeeTest() {
        try(CloseableHttpResponse res = HttpRequestUtil.doPost(READY_URI, null, false)){
            ApiData<GeeTestRes> result = HttpRequestUtil.toApiData(res, new TypeToken<ApiData<GeeTestRes>>(){}.getType());
            return result.getData();
        }catch(Exception e){
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
            throw new HttpRequestFailedException(e.getMessage());
        }
    }
}
