package top.imwonder.sdk.bilibili.domain.smslogin;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class CountryList extends AbstractData{

    private List<Country> common;

    private List<Country> others;

}
