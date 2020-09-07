package top.imwonder.sdk.bilibili.domain.account.safe;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountSns extends AbstractData {

    @SerializedName("weibo_bind")
    private Integer weiboBind;

    @SerializedName("qq_bind")
    private Integer qqBind;
}
