package top.imwonder.sdk.bilibili.enumeration;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum QrCodeStatus {
    WRONG_KEY(-1, "密钥不存在"), TIMEOUT_KEY(-2, "密钥已过期"), WAITING_FOR_SCAN(-4, "等待扫描"), WAITING_FOR_CONFIRM(-5, "等待确认"),
    SUCCESS(200, "成功登录");

    private final Integer code;

    private final String state;

    private static Map<Integer, QrCodeStatus> enumMap;

    static {
        enumMap = new HashMap<>();
        for (QrCodeStatus qcs : values()) {
            enumMap.put(qcs.getCode(), qcs);
        }
    }

    QrCodeStatus(Integer code, String state) {
        this.code = code;
        this.state = state;
    }

    public static QrCodeStatus query(Integer code) {
        return enumMap.get(code);
    }

}
