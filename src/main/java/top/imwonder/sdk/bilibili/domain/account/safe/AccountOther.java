package top.imwonder.sdk.bilibili.domain.account.safe;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountOther extends AbstractData {

    private Boolean skipVerify;

}
