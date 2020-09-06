package top.imwonder.sdk.bilibili.domain.account.safe;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountOther {

    private Boolean skipVerify;

}
