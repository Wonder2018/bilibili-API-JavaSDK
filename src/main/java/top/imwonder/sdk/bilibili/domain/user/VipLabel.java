package top.imwonder.sdk.bilibili.domain.user;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class VipLabel {

    private String path;

    private String text;

    @SerializedName("label_theme")
    private String lableTheme;

}
