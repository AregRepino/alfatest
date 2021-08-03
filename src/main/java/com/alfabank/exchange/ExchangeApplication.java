package com.alfabank.exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchangeApplication {

    public static void main(String... args) {
        SpringApplication.run(ExchangeApplication.class, args);

    }

}
