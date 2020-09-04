package top.imwonder.sdk.bilibili.domain;

import org.apache.http.client.CookieStore;

import lombok.Data;

/**
 * 登录用户
 */
@Data
public class User {

    private final String UID;

    /**uid MD5校验码 */
    private String uidCheckMD5;

    /**登录 Token */
    private String sessdata;

    private String csrfToken;

    private CookieStore cs;
}
