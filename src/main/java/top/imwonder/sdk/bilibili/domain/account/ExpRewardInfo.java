package top.imwonder.sdk.bilibili.domain.account;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExpRewardInfo extends AbstractData {

    private Boolean login;

    private Boolean watch;

    private Double coins;

    private Boolean share;

    private Boolean email;

    private Boolean tel;

    @SerializedName("safe_question")
    private Boolean safeQuestion;

    @SerializedName("identify_card")
    private Boolean identifyCard;
}
