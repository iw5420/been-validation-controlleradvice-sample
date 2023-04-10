package com.ian.sample.dto.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContentValueItem {

    @JsonProperty("Ranking")
    int ranking;

    @JsonProperty("Attribute")
    String attribute;

    @JsonProperty("Value")
    String value;
}
