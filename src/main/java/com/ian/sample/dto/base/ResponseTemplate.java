package com.ian.sample.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseTemplate<S> {

    @JsonProperty("MWHEADER")
    private MwHeader mwHeader;
}
