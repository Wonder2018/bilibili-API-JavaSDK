package top.imwonder.sdk.bilibili.domain.loginsimpleinfo;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper=false)
public class VipLabel extends AbstractData {

    private String path;

    private String text;

    @SerializedName("label_theme")
    private String lableTheme;

}
