package com.ian.sample.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MwHeader {

    @NotBlank(message = "MSGID 不得為空")
    @Size(message = "MSGID 長度不得超過20", max = 20)
    @JsonProperty("MSGID")
    protected String msgId;

    @NotBlank(message = "SOURCECHANNEL 不得為空")
    @JsonProperty("SOURCECHANNEL")
    protected String sourceChannel;

    @NotBlank(message = "TXNSEQ 不得為空")
    @JsonProperty("TXNSEQ")
    protected String txnSeq;

    @JsonProperty("RETURNCODE")
    protected String returnCode;

    @JsonProperty("RETURNDESC")
    protected String returnDesc;

    public MwHeader(String msgId, String sourceChannel, String txnSeq) {
        this.msgId = msgId;
        this.sourceChannel = sourceChannel;
        this.txnSeq = txnSeq;
    }

    public MwHeader(MwHeader header){
        this.msgId = header.getMsgId();
        this.sourceChannel = header.getSourceChannel();
        this.txnSeq = header.getTxnSeq();
    }
}
