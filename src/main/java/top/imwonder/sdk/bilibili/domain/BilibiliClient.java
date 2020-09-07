package top.imwonder.sdk.bilibili.domain;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpRequestBase;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * APP_KEY登录
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BilibiliClient extends AbstractPassport {
    private final String APP_KEY;

    private final String SIGN;

    /** 登录 token */
    private String accessKey;

    /** 刷新 token */
    private String refreshToken;

    /** 上次刷新时间（ms） */
    private long lastRefresh;

    @Override
    public void success(Header[] headers) {
    }

    @Override
    public HttpRequestBase cookRequest(HttpRequestBase req) {
        return req;

    }
}
