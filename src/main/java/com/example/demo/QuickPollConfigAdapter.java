package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by divine on 2017/06/05.
 */

@Configuration
public class QuickPollConfigAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver phmar = new PageableHandlerMethodArgumentResolver();
        phmar.setFallbackPageable(new PageRequest(0, 5));
        argumentResolvers.add(phmar);
        super.addArgumentResolvers(argumentResolvers); // calling the super!! function with more argumanet resolver
    }
}
