package top.imwonder.sdk.bilibili.domain.account.safe;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountInfo extends AbstractData {

    @SerializedName("hide_tel")
    private String hideTel;

    @SerializedName("hide_mail")
    private String hideMail;

    @SerializedName("bind_tel")
    private Boolean bindTel;

    @SerializedName("bind_mail")
    private Boolean bindMail;

    @SerializedName("tel_verify")
    private Boolean telVerify;

    @SerializedName("mail_verify")
    private Boolean mailVerify;

    @SerializedName("unneeded_check")
    private Boolean unneededCheck;

}
