package com.ian.sample.dto.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MailRq {

    @NotEmpty(message = "TxnDateTime 不能為空")
    @JsonProperty("TxnDateTime")
    private String txnDateTime;

    @JsonProperty("Location")
    private String location;

    @JsonProperty("SenderAddress")
    private String senderAddress;

    @JsonProperty("SenderName")
    private String senderName;

    @JsonProperty("ReceiveAddress")
    private String receiveAddress;

    @JsonProperty("CarbonCopyAddress")
    private String carbonCopyAddress;

    @JsonProperty("ContentValue")
    private ContentValue contentValue;

    @JsonProperty("ThemeId")
    private String themeId;
}
