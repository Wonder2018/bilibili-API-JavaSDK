package top.imwonder.sdk.bilibili.domain.user;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Wallet {

    private Integer mid;

    @SerializedName("bcoin_balance")
    private Integer bcoinBalance;

    @SerializedName("coupon_balance")
    private Integer couponBalance;

    @SerializedName("coupon_due_time")
    private Integer couponDueTime;

}
