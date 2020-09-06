package top.imwonder.sdk.bilibili.domain.account.safe;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountSafe {

    @SerializedName("Score")
    private Integer score;

    @SerializedName("pwd_level")
    private Integer pwdLevel;

    private Boolean security;
}
