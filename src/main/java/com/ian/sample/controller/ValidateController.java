package com.ian.sample.controller;

import com.ian.sample.dto.base.MwHeader;
import com.ian.sample.dto.base.RequestTemplate;
import com.ian.sample.dto.mail.MailRq;
import com.ian.sample.enums.SendMailReturnEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidateController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/test")
    public MwHeader test(@Valid@RequestBody RequestTemplate<MailRq>request){
        logger.info(request.toString());
        MwHeader mwHeader = new MwHeader();
        mwHeader.setReturnCode(SendMailReturnEnum.SUCCESS.getReturnCode());
        mwHeader.setReturnDesc(SendMailReturnEnum.SUCCESS.getDesc());
        return mwHeader;
    }
}
