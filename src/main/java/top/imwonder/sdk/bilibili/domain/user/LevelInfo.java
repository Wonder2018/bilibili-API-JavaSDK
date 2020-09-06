package top.imwonder.sdk.bilibili.domain.user;

import com.google.gson.annotations.SerializedName;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class LevelInfo {

    @SerializedName("current_level")
    private Integer currentLevel;

    @SerializedName("current_min")
    private Integer currentMin;

    @SerializedName("current_exp")
    private Integer currentExp;

    @SerializedName("next_exp")
    private Integer nextExp;

}
