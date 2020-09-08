package top.imwonder.sdk.bilibili.enumeration;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum SmsCaptchaStatus {
    SUCCESS(0,"登录成功");

    private final Integer code;

    private final String state;

    private static Map<Integer, SmsCaptchaStatus> enumMap;

    static {
        enumMap = new HashMap<>();
        for (SmsCaptchaStatus scs : values()) {
            enumMap.put(scs.getCode(), scs);
        }
    }

    SmsCaptchaStatus(Integer code, String state) {
        this.code = code;
        this.state = state;
    }

    public static SmsCaptchaStatus query(Integer code) {
        return enumMap.get(code);
    }
}
