package top.imwonder.sdk.bilibili.domain.account;

import java.util.Date;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.annotations.JsonDateFormat;
import top.imwonder.config.AbstractDataDateFormatConfig;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonAdapter(value = AbstractDataDateFormatConfig.class)
public class BaseUserInfo extends AbstractData {

    private Integer mid;

    private String uname;

    private String userid;

    private String sign;

    @JsonDateFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    private String sex;

    @SerializedName("nick_free")
    private Boolean nickFree;

    private String rank;
}
