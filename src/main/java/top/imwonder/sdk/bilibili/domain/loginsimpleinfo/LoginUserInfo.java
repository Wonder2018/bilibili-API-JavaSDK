package top.imwonder.sdk.bilibili.domain.loginsimpleinfo;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginUserInfo extends AbstractData {

    private Boolean isLogin;

    @SerializedName("email_verified")
    private Integer emailVerified;

    private String face;

    @SerializedName("level_info")
    private LevelInfo levelInfo;

    private Integer mid;

    @SerializedName("mobile_verified")
    private Integer mobileVerified;

    private Integer money;

    private Integer moral;

    private Official official;

    private OfficialVerify officialVerify;

    private Pendant pendant;

    private Integer scores;

    private String uname;

    private Integer vipDueDate;

    private Integer vipStatus;

    private Integer vipType;

    @SerializedName("vip_pay_type")
    private Integer vipPayType;

    @SerializedName("vip_theme_type")
    private Integer vipThemeType;

    @SerializedName("vip_label")
    private VipLabel vipLabel;

    @SerializedName("vip_avatar_subscript")
    private Integer vipAvatarSubscript;

    @SerializedName("vip_nickname_color")
    private String vipNicknameColor;

    private Wallet wallet;

    @SerializedName("has_shop")
    private Boolean hasShop;

    @SerializedName("shop_url")
    private String shopUrl;

    @SerializedName("allowance_count")
    private Integer allowanceCount;

    @SerializedName("answer_status")
    private Integer answerStatus;

    private Integer bCoins;

    private Double coins;

    @SerializedName("nameplate_current")
    private Object nameplateCurrent;

    @SerializedName("pendant_current")
    private String pendantCurrent;

    private String userStatus;

    @SerializedName("official_verify")
    private Integer officialVerify2;

    private Integer pointBalance;

    private NavState navState;

}
