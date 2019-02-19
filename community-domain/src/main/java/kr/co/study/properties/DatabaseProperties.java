package kr.co.study.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Validated
@Component
@ConfigurationProperties("spring.datasource")
public class DatabaseProperties {

    @NotEmpty
    private String url;

    private String driverClassName;

}
