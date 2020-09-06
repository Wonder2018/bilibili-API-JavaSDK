package top.imwonder.sdk.bilibili.domain.account;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.account.safe.AccountInfo;
import top.imwonder.sdk.bilibili.domain.account.safe.AccountOther;
import top.imwonder.sdk.bilibili.domain.account.safe.AccountSafe;
import top.imwonder.sdk.bilibili.domain.account.safe.AccountSns;

@Data
@EqualsAndHashCode(callSuper = false)
public class PassportInfo {

    @SerializedName("account_info")
    private AccountInfo accountInfo;

    @SerializedName("account_safe")
    private AccountSafe accountSafe;

    @SerializedName("account_sns")
    private AccountSns accountSns;

    @SerializedName("account_other")
    private AccountOther accountOther;
}
