package com.alfabank.exchange.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Data
@Validated
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String currency;
}
