package top.imwonder.sdk.bilibili.domain.loginsimpleinfo;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper=false)
public class Wallet extends AbstractData {

    private Integer mid;

    @SerializedName("bcoin_balance")
    private Integer bcoinBalance;

    @SerializedName("coupon_balance")
    private Integer couponBalance;

    @SerializedName("coupon_due_time")
    private Integer couponDueTime;

}
