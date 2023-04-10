package com.ian.sample.dto.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class ContentValue {

    @NotEmpty(message = "Subject 不能為空")
    @JsonProperty("Subject")
    private String subject;

    @JsonProperty("Salutation")
    private String salutation;

    @NotEmpty(message = "Content 不能為空")
    @JsonProperty("Content")
    private String content;

    @JsonProperty("ContentTemplateID")
    private String contentTemplateID;

    @JsonProperty("Items")
    private List<ContentValueItem> items;
}
