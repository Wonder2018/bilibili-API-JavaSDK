package top.imwonder.sdk.bilibili.domain;

import lombok.Data;

/**
 * APP_KEY登录
 */
@Data
public class BilibiliClient {
    private final String APP_KEY;

    private final String SIGN;

    /**登录 token */
    private String accessKey;

    /**刷新 token */
    private String refreshToken;

    /**上次刷新时间（ms） */
    private long lastRefresh;
}
