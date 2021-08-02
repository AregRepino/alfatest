package com.alfabank.exchange.controller;

import com.alfabank.exchange.clients.dto.giphy.GiphyData;
import com.alfabank.exchange.service.AppConfig;
import com.alfabank.exchange.service.ExchangeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)

public class ExchangeControllerTest {
    @Configuration
    @Import(ExchangeController.class)
    static class Config {
    }


    @MockBean
    private ExchangeService exchangeService;

    @MockBean
    private AppConfig appConfig;

    @Autowired
    private ExchangeController exchangeController;

    @Test
    public void getCurrencyExchangeGif() {

//        given
        GiphyData giphyData = new GiphyData();
        given(exchangeService.chooseGif(anyString())).willReturn(giphyData);

//        when
        GiphyData result = exchangeController.getCurrencyExchangeGif("RUB");

//        then
        assertNotNull(result);
        assertEquals(giphyData, result);
    }


    @Test
    public void getCurrencyExchangeGifWithDefaultCurrency() {

//        given
        given(appConfig.getCurrency()).willReturn("EUR");
        GiphyData giphyData = new GiphyData();
        given(exchangeService.chooseGif("EUR")).willReturn(giphyData);

//        when
        GiphyData result = exchangeController.getCurrencyExchangeGif(null);

//        then
        assertNotNull(result);
        assertEquals(giphyData, result);
    }



}
