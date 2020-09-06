package top.imwonder.sdk.bilibili.utilTest;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Test;

import top.imwonder.sdk.bilibili.util.HttpRequestUtil;

public class HttpRequestUtilTest {

    @Test
    public void doGetTest() throws Exception {
        try (CloseableHttpResponse res = HttpRequestUtil.doGet("https://www.imwonder.top/jsonTestAjax", null, false)) {
            Map<String, Object> test = HttpRequestUtil.toResultMap(res);
            assertEquals(404.0, test.get("code"));
            assertEquals("您请求的资源未找到！", test.get("msg"));
        }

    }
}
