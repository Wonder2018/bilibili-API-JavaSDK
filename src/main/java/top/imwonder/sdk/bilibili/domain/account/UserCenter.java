package top.imwonder.sdk.bilibili.domain.account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserCenter extends AbstractData{

    private BaseUserInfo baseUserInfo;

    private ExpRewardInfo expRewardInfo;

    private VipStatus vipStatus;

    private PassportInfo passportInfo;

    private Boolean realnameStatus;

    private RealnameInfo realnameInfo;

    private CoinLog coinLog;

}
