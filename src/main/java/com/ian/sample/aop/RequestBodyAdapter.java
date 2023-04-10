package com.ian.sample.aop;

import com.ian.sample.dto.base.RequestTemplate;
import com.ian.sample.component.WebRequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;

@RestControllerAdvice
@RequiredArgsConstructor
public class RequestBodyAdapter extends RequestBodyAdviceAdapter {

    private final WebRequestContext context;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType,
           Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        if(body instanceof RequestTemplate<?>){
            RequestTemplate<?>baseRequest = (RequestTemplate<?>)body;
            context.setMwHeader(baseRequest.getMwHeader());
        }
        return body;
    }
}
