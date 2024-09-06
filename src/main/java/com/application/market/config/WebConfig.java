package com.application.market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/*
I created this class, because i was getting error 405 Method Not Allowed when i try to delete a tour
and also i was getting error with Request method 'POST' is not supported.

This class is i think for @DeleteMapping and @PutMapping
 */

@Configuration
public class WebConfig {

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}