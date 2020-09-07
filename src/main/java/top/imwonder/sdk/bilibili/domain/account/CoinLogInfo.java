package top.imwonder.sdk.bilibili.domain.account;

import com.google.gson.annotations.JsonAdapter;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.annotations.JsonDateFormat;
import top.imwonder.config.AbstractDataDateFormatConfig;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonAdapter(value = AbstractDataDateFormatConfig.class)
public class CoinLogInfo  extends AbstractData {

    @JsonDateFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Data time;

    private Integer delta;

    private String reason;
}
