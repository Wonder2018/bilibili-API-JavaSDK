package top.imwonder.sdk.bilibili.domain.loginsimpleinfo;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper=false)
public class NavState extends AbstractData {

    private Integer follwoing;

    private Integer follower;

    @SerializedName("dynaminc_count")
    private Integer dynamincCount;
}
