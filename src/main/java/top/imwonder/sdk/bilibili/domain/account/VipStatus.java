package top.imwonder.sdk.bilibili.domain.account;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class VipStatus {

    private Integer mid;

    @SerializedName("vip_type")
    private Integer vipType;

    @SerializedName("vip_status")
    private Integer vipStatus;

    @SerializedName("vip_due_date")
    private Integer vipDueDate;

    @SerializedName("vip_pay_type")
    private Integer vipPayType;

    @SerializedName("vip_theme_type")
    private Integer vipThemeType;
}
