package com.alfabank.exchange.service;

import com.alfabank.exchange.clients.GiphyClient;
import com.alfabank.exchange.clients.OpenExchangeRatesClient;
import com.alfabank.exchange.clients.dto.giphy.GiphyData;
import com.alfabank.exchange.clients.dto.giphy.GiphySearchResponseDto;
import com.alfabank.exchange.clients.dto.oxr.ExchangeResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
public class ExchangeServiceTest {
    @Configuration
    @Import(ExchangeService.class)
    static class Config {
    }

    @MockBean
    private OpenExchangeRatesClient oxrClient;

    @MockBean
    private GiphyClient giphyClient;


    @Autowired
    private ExchangeService exchangeService;


    @Test
    public void chooseGif() {
//        given
        ExchangeResponseDto latestExchangeResponseDto = this.createLatestExchangeResponseDto();

        ExchangeResponseDto yesterdayExchangeResponseDto = this.createYesterdayExchangeResponseDto();

        LocalDate yesterday = LocalDate.now().minusDays(1);

        given(this.oxrClient.getLatest()).willReturn(latestExchangeResponseDto);

        given(this.oxrClient.getHistorical(yesterday.toString())).willReturn(yesterdayExchangeResponseDto);

        GiphySearchResponseDto giphySearchResponseDto = this.createGiphySearchResponseDto();
        GiphyData expectedGiphyData = giphySearchResponseDto.getData().get(0);

        given(this.giphyClient.search(anyString())).willReturn(giphySearchResponseDto);

//        when

        GiphyData result = exchangeService.chooseGif("RUB");


//        them
        assertNotNull(result);
        assertEquals(expectedGiphyData, result);

    }


    private ExchangeResponseDto createLatestExchangeResponseDto() {
        ExchangeResponseDto latestExchangeResponseDto = new ExchangeResponseDto();
        Map<String, Double> rates = new HashMap<>();
        rates.put("RUB", 70.05);
        rates.put("EUR", 0.9);
        latestExchangeResponseDto.setRates(rates);
        return latestExchangeResponseDto;
    }

    private ExchangeResponseDto createYesterdayExchangeResponseDto() {
        ExchangeResponseDto yesterdayExchangeResponseDto = new ExchangeResponseDto();
        Map<String, Double> rates = new HashMap<>();
        rates.put("RUB", 77.05);
        rates.put("EUR", 0.85);
        yesterdayExchangeResponseDto.setRates(rates);
        return yesterdayExchangeResponseDto;
    }

    private GiphySearchResponseDto createGiphySearchResponseDto() {
        GiphySearchResponseDto giphySearchResponseDto = new GiphySearchResponseDto();

        List<GiphyData> giphyDataList = new ArrayList<>();
        GiphyData giphyData = new GiphyData();
        giphyData.setUrl("anyUrl");
        giphyData.setBitlyUrl("anyBitlyUrl");
        giphyDataList.add(giphyData);

        giphySearchResponseDto.setData(giphyDataList);
        return giphySearchResponseDto;
    }

}
