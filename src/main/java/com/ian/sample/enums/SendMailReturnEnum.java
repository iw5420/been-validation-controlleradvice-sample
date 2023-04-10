package com.ian.sample.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SendMailReturnEnum {
    SUCCESS(200, "0000", "交易成功"),
    FAIL(200, "9999", "發送失敗"),
    INVALIDARGUMENTS(200, "E101", "檢核錯誤"),
    UNKNOWN(200, "E999", "不明或未定義錯誤");

    private int statusCode;
    private String returnCode;
    private String desc;
}
