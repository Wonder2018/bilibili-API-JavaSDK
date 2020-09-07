package top.imwonder.sdk.bilibili.domain;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.methods.HttpRequestBase;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 登录用户
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractPassport {

    // 登录信息
    private Integer UID;

    /** uid MD5校验码 */
    private String uidCheckMD5;

    /** 登录 Token */
    private String sessdata;

    private String csrfToken;

    @Override
    public void success(Header[] headers) {
        for (Header header : headers) {
            HeaderElement firstElement = header.getElements()[0];
            switch (firstElement.getName()) {
                case "DedeUserID":
                    setUID(Integer.valueOf(firstElement.getValue()));
                    break;
                case "DedeUserID__ckMd5":
                    setUidCheckMD5(firstElement.getValue());
                    break;
                case "SESSDATA":
                    setSessdata(firstElement.getValue());
                    break;
                case "bili_jct":
                    setCsrfToken(firstElement.getValue());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public HttpRequestBase cookRequest(HttpRequestBase req) {
        return req;

    }

}
