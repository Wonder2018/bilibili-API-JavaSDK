package top.imwonder.sdk.bilibili.domain.loginsimpleinfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper=false)
public class Official extends AbstractData {

    private Integer role;

    private String title;

    private String desc;

    private Integer type;

}
