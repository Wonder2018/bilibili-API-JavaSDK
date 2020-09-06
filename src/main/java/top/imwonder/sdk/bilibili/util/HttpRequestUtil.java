package top.imwonder.sdk.bilibili.util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import lombok.extern.slf4j.Slf4j;
import top.imwonder.sdk.bilibili.domain.ApiData;
import top.imwonder.util.MessageUtil;

/**
 * 发送请求
 */
@Slf4j
public class HttpRequestUtil {

    private static Gson gson = new Gson();

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    private HttpRequestUtil() {
    };

    public static void resetHttpClient() {
        try {
            httpClient.close();
        } catch (IOException e) {
            log.info(MessageUtil.getMsg("util.httprequest.error.closeclient"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
        }
        httpClient = HttpClients.createDefault();
    }

    /**
     * 发送无需登录的 Get 请求
     *
     * @param api    请求接口
     * @param params 请求参数
     * @return 返回 Json 对应的 {@link java.util.Map Map&lt;String, Object&gt;}
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static CloseableHttpResponse doGet(String api, Map<String, String> params)
            throws ClientProtocolException, IOException, URISyntaxException {
        return doGet(api, params, true);
    }

    /**
     * 发送无需登录的 Get 请求
     *
     * @param api       请求接口
     * @param params    请求参数
     * @param autoClose 自动关闭连接
     * @return 返回 Json 对应的 {@link java.util.Map Map&lt;String, Object&gt;}
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static CloseableHttpResponse doGet(String api, Map<String, String> params, boolean autoClose)
            throws ClientProtocolException, IOException, URISyntaxException {
        URIBuilder uri = new URIBuilder();
        uri.setPath(api);
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                uri.setParameter(key, params.get(key));
            }
        }
        return doGet(uri.build(), autoClose);
    }

    /**
     * 发送无需登录的 Get 请求
     *
     * @param uri 请求信息
     * @return 返回 Json 对应的 {@link java.util.Map Map&lt;String, Object&gt;}
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static CloseableHttpResponse doGet(URI uri) throws ClientProtocolException, IOException, URISyntaxException {
        return doGet(uri, true);
    }

    /**
     * 发送无需登录的 Get 请求
     *
     * @param uri       请求信息
     * @param autoClose 自动关闭连接
     * @return 返回 Json 对应的 {@link java.util.Map Map&lt;String, Object&gt;}
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static CloseableHttpResponse doGet(URI uri, boolean autoClose)
            throws ClientProtocolException, IOException, URISyntaxException {
        HttpGet get = new HttpGet(uri);
        return doRequest(get, autoClose);
    }

    /**
     * 发送无需登录的 Post 请求
     *
     * @param api    请求接口
     * @param params 请求参数
     * @return 返回 Json 对应的 {@link java.util.Map Map&lt;String, Object&gt;}
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static CloseableHttpResponse doPost(String api, Map<String, String> params)
            throws ClientProtocolException, IOException, URISyntaxException {
        return doPost(api, params, true);
    }

    /**
     * 发送无需登录的 Post 请求
     *
     * @param api       请求接口
     * @param params    请求参数
     * @param autoClose 自动关闭连接
     * @return 返回 Json 对应的 {@link java.util.Map Map&lt;String, Object&gt;}
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static CloseableHttpResponse doPost(String api, Map<String, String> params, boolean autoClose)
            throws ClientProtocolException, IOException, URISyntaxException {
        URIBuilder uri = new URIBuilder();
        uri.setPath(api);
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                uri.setParameter(key, params.get(key));
            }
        }
        return doPost(uri.build(), autoClose);
    }

    /**
     * 发送无需登录的 Post 请求
     *
     * @param uri 请求信息
     * @return 返回 Json 对应的 {@link java.util.Map Map&lt;String, Object&gt;}
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static CloseableHttpResponse doPost(URI uri)
            throws ClientProtocolException, IOException, URISyntaxException {
        return doPost(uri, true);
    }

    /**
     * 发送无需登录的 Post 请求
     *
     * @param uri       请求信息
     * @param autoClose 自动关闭连接
     * @return 返回 Json 对应的 {@link java.util.Map Map&lt;String, Object&gt;}
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static CloseableHttpResponse doPost(URI uri, boolean autoClose)
            throws ClientProtocolException, IOException, URISyntaxException {
        HttpPost post = new HttpPost(uri);
        return doRequest(post, autoClose);
    }

    public static CloseableHttpResponse doRequest(HttpRequestBase req) throws ClientProtocolException, IOException {
        return doRequest(req, true);
    }

    public static CloseableHttpResponse doRequest(HttpRequestBase req, boolean autoClose)
            throws ClientProtocolException, IOException {
        resetHttpClient();
        setComonHeader(req);
        if (autoClose) {
            try (CloseableHttpResponse httpResponse = httpClient.execute(req)) {
                return httpResponse;
            }
        } else {
            return httpClient.execute(req);
        }
    }

    public static void setComonHeader(HttpRequestBase req) {
        String ua = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36";
        req.setHeader(HttpHeaders.CONNECTION, "keep-alive");
        req.setHeader(HttpHeaders.USER_AGENT, ua);
        req.setHeader(HttpHeaders.REFERER, "https://www.bilibili.com");
    }

    public static Map<String, Object> toResultMap(HttpResponse res)
            throws JsonSyntaxException, ParseException, IOException {
        return gson.fromJson(EntityUtils.toString(res.getEntity()), new TypeToken<HashMap<String, Object>>() {
        }.getType());
    }

    public static <T> ApiData<T> toApiData(HttpResponse res, Type type)
            throws JsonSyntaxException, ParseException, IOException {
        return gson.fromJson(EntityUtils.toString(res.getEntity()), type);
    }
}
