package com.ian.sample.aop;

import com.ian.sample.dto.base.MwHeader;
import com.ian.sample.dto.base.ResponseTemplate;
import com.ian.sample.component.WebRequestContext;
import com.ian.sample.enums.SendMailReturnEnum;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;


@RestControllerAdvice
@RequiredArgsConstructor
public class GlobeExceptionHandler {

    private final WebRequestContext context;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseTemplate<MwHeader>> handleValidationErrors(MethodArgumentNotValidException exception){
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> errorList= bindingResult.getFieldErrors();
        String errorMessage = errorList.size() > 0 ? errorList.get(0).getDefaultMessage() : "資料格式錯誤";
        logger.error("[ERROR][argument]:{}", errorMessage);
        MwHeader mwHeader = new MwHeader(context.getMwHeader());
        mwHeader.setReturnCode(SendMailReturnEnum.INVALIDARGUMENTS.getReturnCode());
        mwHeader.setReturnDesc(errorMessage);
        ResponseTemplate baseResponse = new ResponseTemplate<>();
        baseResponse.setMwHeader(mwHeader);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseTemplate<MwHeader>>handleException(Exception exception){
        logger.error("[error][general]:{}",exception.getMessage());
        MwHeader mwHeader = new MwHeader(context.getMwHeader());
        mwHeader.setReturnCode(SendMailReturnEnum.UNKNOWN.getReturnCode());
        ResponseTemplate baseResponse = new ResponseTemplate<>();
        baseResponse.setMwHeader(mwHeader);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
