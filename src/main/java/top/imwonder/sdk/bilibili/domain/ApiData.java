package top.imwonder.sdk.bilibili.domain;

import lombok.Data;

@Data
public class ApiData {

    private Double code;

    private String message;

    private Double ttl;

    private Object data;
}
