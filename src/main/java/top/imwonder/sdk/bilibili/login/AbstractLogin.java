/*
 * @Author: Wonder2019
 * @Date: 2020-09-06 14:20:26
 * @Last Modified by:   Wonder2019
 * @Last Modified time: 2020-09-06 14:20:26
 */
package top.imwonder.sdk.bilibili.login;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import lombok.Getter;
import top.imwonder.sdk.bilibili.domain.User;

public abstract class AbstractLogin {

    /** 登录成功的用户 */
    @Getter
    protected User user;

    /** 虚拟客户端 */
    protected CloseableHttpClient httpClient;

    public AbstractLogin() {
        this.httpClient = HttpClients.createDefault();
    }

    protected void success(Header[] headers) {
        user = new User();
        for (Header header : headers) {
            HeaderElement firstElement = header.getElements()[0];
            switch (firstElement.getName()) {
                case "DedeUserID":
                    user.setUID(Integer.valueOf(firstElement.getValue()));
                    break;
                case "DedeUserID__ckMd5":
                    user.setUidCheckMD5(firstElement.getValue());
                    break;
                case "SESSDATA":
                    user.setSessdata(firstElement.getValue());
                    break;
                case "bili_jct":
                    user.setCsrfToken(firstElement.getValue());
                    break;
                default:
                    break;
            }
        }
        user.setClient(httpClient);
    }
}
