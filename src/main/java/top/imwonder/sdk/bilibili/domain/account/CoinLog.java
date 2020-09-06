package top.imwonder.sdk.bilibili.domain.account;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CoinLog {

    private List<CoinLogInfo> list;

    private Integer count;

}
