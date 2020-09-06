package top.imwonder.sdk.bilibili.domain.account.safe;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountSns {

    @SerializedName("weibo_bind")
    private Integer weiboBind;

    @SerializedName("qq_bind")
    private Integer qqBind;
}
