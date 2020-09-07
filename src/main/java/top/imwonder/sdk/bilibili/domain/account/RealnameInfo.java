package top.imwonder.sdk.bilibili.domain.account;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class RealnameInfo extends AbstractData {

    private Integer status;

    private String remark;

    private String realname;

    private String card;

    @SerializedName("card_type")
    private Integer cardType;
}
