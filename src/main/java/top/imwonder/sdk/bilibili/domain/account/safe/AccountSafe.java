package top.imwonder.sdk.bilibili.domain.account.safe;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountSafe extends AbstractData {

    @SerializedName("Score")
    private Integer score;

    @SerializedName("pwd_level")
    private Integer pwdLevel;

    private Boolean security;
}
