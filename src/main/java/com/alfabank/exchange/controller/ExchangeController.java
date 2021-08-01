package com.alfabank.exchange.controller;

import com.alfabank.exchange.clients.dto.giphy.GiphyData;
import com.alfabank.exchange.service.AppConfig;
import com.alfabank.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;
    private final AppConfig appConfig;

    @ResponseStatus(OK)
    @GetMapping(value = "/exchange/gif", produces = "application/json")
    @ResponseBody
    public GiphyData getCurrencyExchangeGif(@RequestParam(value = "currency", required = false) String currency) {
        if (currency == null) {
            currency = appConfig.getCurrency();
        }
        return exchangeService.chooseGif(currency);
    }
}
