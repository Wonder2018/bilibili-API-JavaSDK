package top.imwonder.sdk.bilibili.domain;

import lombok.Data;

@Data
public class ApiData<T extends AbstractData> {

    private Integer code;

    private String message;

    private Integer ttl;

    private T data;

}
