package top.imwonder.sdk.bilibili.domain.loginsimpleinfo;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper=false)
public class LevelInfo extends AbstractData {

    @SerializedName("current_level")
    private Integer currentLevel;

    @SerializedName("current_min")
    private Integer currentMin;

    @SerializedName("current_exp")
    private Integer currentExp;

    @SerializedName("next_exp")
    private Integer nextExp;

}
