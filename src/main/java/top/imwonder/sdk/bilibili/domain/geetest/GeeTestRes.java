package top.imwonder.sdk.bilibili.domain.geetest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class GeeTestRes extends AbstractData {

    private Integer type;

    private GeeTestInfo result;

    private String validate;

    private String seccode;

    /**
     * GeeTest ID
     *
     * @return
     */
    public String getGt() {
        return result.getGt();
    }

    /**
     * GeeTest Key
     *
     * @return
     */
    public String getChallenge() {
        return result.getChallenge();
    }

    /**
     * Login Key
     *
     * @return
     */
    public String getKey() {
        return result.getKey();
    }

}

@Data
@EqualsAndHashCode(callSuper = false)
final class GeeTestInfo {

    private Integer success;

    private String gt;

    private String challenge;

    private String key;

}
