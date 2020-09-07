/*
 * @Author: Wonder2019
 * @Date: 2020-09-06 14:20:26
 * @Last Modified by:   Wonder2019
 * @Last Modified time: 2020-09-06 14:20:26
 */
package top.imwonder.sdk.bilibili.login;

import org.apache.http.impl.client.CloseableHttpClient;

import lombok.Getter;
import top.imwonder.sdk.bilibili.domain.AbstractPassport;

public abstract class AbstractLogin<T extends AbstractPassport> {

    /** 登录成功的用户 */
    @Getter
    protected final T bilibiliAuth;

    /** 虚拟客户端 */
    protected final CloseableHttpClient httpClient;

    protected AbstractLogin(T bilibiliAuth) {
        this.bilibiliAuth = bilibiliAuth;
        this.httpClient = bilibiliAuth.getClient();
    }
}
