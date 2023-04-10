package com.ian.sample.component;

import com.ian.sample.dto.base.MwHeader;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Optional;

@Data
@Component
@RequestScope
public class WebRequestContext {

    private MwHeader mwHeader = new MwHeader();

    public MwHeader getMwHeader(){
        return Optional.ofNullable(mwHeader).orElse(new MwHeader(mwHeader));
    }
}
