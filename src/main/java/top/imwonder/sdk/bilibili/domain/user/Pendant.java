package top.imwonder.sdk.bilibili.domain.user;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Pendant {

    private Integer pid;

    private String name;

    private String image;

    private Integer expire;

    @SerializedName("image_enhance")
    private String imageEnhance;
}
