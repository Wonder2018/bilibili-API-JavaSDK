package top.imwonder.sdk.bilibili.domain.account;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class CoinLog extends AbstractData {

    private List<CoinLogInfo> list;

    private Integer count;

}
