package com.colak.springopentelemetrytutorial.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class Service1 {

    private final RestTemplate restTemplate;

    @Autowired
    public Service1(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String service1() {
        log.info("service1 begin");
        String url = "http://localhost:8080/api/v1/service1/method2";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String body = responseEntity.getBody();

        log.info("service1 end");
        return "service1 got : " + body;
    }
}
