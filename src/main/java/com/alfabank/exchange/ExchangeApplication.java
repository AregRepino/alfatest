package com.alfabank.exchange;

import com.alfabank.exchange.clients.GiphyClient;
import com.alfabank.exchange.clients.OpenExchangeRatesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchangeApplication {
    @Autowired
    private OpenExchangeRatesClient oxrClient;


    @Autowired
    private GiphyClient giphyClient;


    public static void main(String... args) {
        SpringApplication.run(ExchangeApplication.class, args);


    }

}
