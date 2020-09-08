package top.imwonder.sdk.bilibili.domain.smslogin;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imwonder.sdk.bilibili.domain.AbstractData;

@Data
@EqualsAndHashCode(callSuper = false)
public class Country extends AbstractData{

    private Integer id;

    private String cname;

    @SerializedName("country_id")
    private String countryId;
}
