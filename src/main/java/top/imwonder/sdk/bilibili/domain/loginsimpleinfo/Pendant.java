package top.imwonder.sdk.bilibili.domain.loginsimpleinfo;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper=false)
public class Pendant extends AbstractData {

    private Integer pid;

    private String name;

    private String image;

    private Integer expire;

    @SerializedName("image_enhance")
    private String imageEnhance;
}
