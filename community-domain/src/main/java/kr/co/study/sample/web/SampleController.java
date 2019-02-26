package kr.co.study.sample.web;

import kr.co.study.properties.DatabaseProperties;
import kr.co.study.sample.dto.SampleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by coupang on 2017. 5. 26..
 */
@RestController
public class SampleController {

    @Autowired
    DatabaseProperties properties;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    // Login Page
    @GetMapping("/")
    public SampleDto index() {
        SampleDto dto = new SampleDto();
        dto.setDriver(properties.getDriverClassName());
        dto.setUrl(properties.getUrl());
        return dto;
    }

}
