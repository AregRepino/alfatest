package com.alfabank.exchange.clients;

import com.alfabank.exchange.clients.dto.oxr.ExchangeResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${openexchangerates.name}", url = "${openexchangerates.url}")

public interface OpenExchangeRatesClient {
    //    https://openexchangerates.org/api/latest.json
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/latest.json?app_id=${openexchangerates.appId}")
    ExchangeResponseDto getLatest();

    //    https://openexchangerates.org/api/historical/:date.json
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/historical/{date}.json?app_id=${openexchangerates.appId}")
    ExchangeResponseDto getHistorical(@PathVariable(name = "date") String date);

}
