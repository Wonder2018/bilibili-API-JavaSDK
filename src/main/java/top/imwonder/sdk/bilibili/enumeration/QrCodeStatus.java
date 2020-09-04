package top.imwonder.sdk.bilibili.enumeration;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum QrCodeStatus {
    WRONG_KEY(-1d, "密钥不存在"), TIMEOUT_KEY(-2d, "密钥已过期"), WAITING_FOR_SCAN(-4d, "等待扫描"), WAITING_FOR_CONFIRM(-5d, "等待确认"),
    SUCCESS(200d, "成功登录");

    private final Double code;

    private final String status;

    private static Map<Double, QrCodeStatus> enumMap;

    static {
        enumMap = new HashMap<>();
        for (QrCodeStatus qcs : values()) {
            enumMap.put(qcs.getCode(), qcs);
        }
    }

    QrCodeStatus(Double code, String status) {
        this.code = code;
        this.status = status;
    }

    public static QrCodeStatus query(Double code) {
        return enumMap.get(code);
    }

}
