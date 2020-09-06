package top.imwonder.sdk.bilibili.domain.loginsimpleinfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper=false)
public class OfficialVerify extends AbstractData {

    private Integer type;

    private String desc;
}
