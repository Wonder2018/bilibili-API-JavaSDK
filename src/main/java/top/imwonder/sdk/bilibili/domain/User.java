package top.imwonder.sdk.bilibili.domain;

import org.apache.http.impl.client.CloseableHttpClient;

import lombok.Data;

/**
 * 登录用户
 */
@Data
public class User {

    // 登录信息
    private Integer UID;

    private CloseableHttpClient client;

    /** uid MD5校验码 */
    private String uidCheckMD5;

    /** 登录 Token */
    private String sessdata;

    private String csrfToken;

}
