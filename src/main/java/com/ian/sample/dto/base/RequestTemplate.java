package com.ian.sample.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class RequestTemplate<Q>{

    @Valid
    @NotNull(message = "標頭不得為空")
    @JsonProperty("MWHEADER")
    private MwHeader mwHeader;

    @Valid
    @NotNull(message = "TRANRQ不得為空")
    @JsonProperty("TRANRQ")
    private Q tranrq;

}
