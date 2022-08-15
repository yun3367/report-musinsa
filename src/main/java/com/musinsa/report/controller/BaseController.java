package com.musinsa.report.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.PostConstruct;

public interface BaseController {
    ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    default void Init(){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }
}
