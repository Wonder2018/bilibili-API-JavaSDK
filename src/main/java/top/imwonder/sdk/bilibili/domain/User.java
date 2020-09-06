package top.imwonder.sdk.bilibili.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.google.gson.annotations.SerializedName;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.CloseableHttpClient;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import top.imwonder.sdk.bilibili.domain.user.LevelInfo;
import top.imwonder.sdk.bilibili.domain.user.Official;
import top.imwonder.sdk.bilibili.domain.user.OfficialVerify;
import top.imwonder.sdk.bilibili.domain.user.Pendant;
import top.imwonder.sdk.bilibili.domain.user.VipLabel;
import top.imwonder.sdk.bilibili.domain.user.Wallet;
import top.imwonder.util.MessageUtil;
import top.imwonder.util.StringUtil;

/**
 * 登录用户
 */
@Data
@Slf4j
public class User {

    // 登录信息

    private Integer UID;

    private CloseableHttpClient client;

    /** uid MD5校验码 */
    private String uidCheckMD5;

    /** 登录 Token */
    private String sessdata;

    private String csrfToken;

    private CookieStore cs;

    // 用户信息
    private Integer mid;

    private Boolean isLogin;

    @SerializedName("email_verified")
    private Integer emailVerified;

    private String face;

    @SerializedName("level_info")
    private LevelInfo levelInfo;

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



    public void copyFrom(User user, boolean isCover) {
        Field fields[] = User.class.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = StringUtil.upperFirstChar(field.getName());
                if ("Log".equals(fieldName)) {
                    continue;
                }
                Method getter = User.class.getMethod(String.format("get%s", fieldName));
                Object ov = getter.invoke(this);
                Object nv = getter.invoke(user);
                if (isCover || (ov == null && nv != null)) {
                    Method setter = User.class.getMethod(String.format("set%s", fieldName), field.getType());
                    setter.invoke(this, nv);
                }
                field.setAccessible(false);
            }
        } catch (Exception e) {
            log.info(MessageUtil.getMsg("error.unexpected"));
            log.debug(MessageUtil.getMsg("error.debug.simple", e.getMessage()));
            e.printStackTrace();
        }
    }

}
