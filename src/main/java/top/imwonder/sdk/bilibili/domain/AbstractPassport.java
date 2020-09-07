package top.imwonder.sdk.bilibili.domain;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import lombok.Data;

@Data
public abstract class AbstractPassport {

    protected static String QR_CODE_API;

    protected CloseableHttpClient client = HttpClients.createDefault();

    public abstract void success(Header[] headers);

    public abstract HttpRequestBase cookRequest(HttpRequestBase req);
}
