package com.alfabank.exchange.service;

import com.alfabank.exchange.clients.GiphyClient;
import com.alfabank.exchange.clients.OpenExchangeRatesClient;
import com.alfabank.exchange.clients.dto.giphy.GiphyData;
import com.alfabank.exchange.clients.dto.giphy.GiphySearchResponseDto;
import com.alfabank.exchange.clients.dto.oxr.ExchangeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ExchangeService {
    private final OpenExchangeRatesClient oxrClient;
    private final GiphyClient giphyClient;


    public GiphyData chooseGif(String currency) {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        ExchangeResponseDto latestExchange = oxrClient.getLatest();
        ExchangeResponseDto yesterdayExchange = oxrClient.getHistorical(yesterday.toString());

        double todayValue = latestExchange.getRates().getOrDefault(currency, 0.0);
        double yesterdayValue = yesterdayExchange.getRates().getOrDefault(currency, 0.0);

        String query = buildQueryKeyword(todayValue, yesterdayValue);

        GiphySearchResponseDto giphySearchResponseDto = giphyClient.search(query);

        int count = giphySearchResponseDto.getData().size();
        int random = (int) ( Math.random() * ( count - 1 ) );

        GiphyData giphyData = giphySearchResponseDto.getData().get(random);

        return giphyData;
    }

    private String buildQueryKeyword(double todayValue, double yesterdayValue) {
        if (todayValue > yesterdayValue) {
            return "rich";
        } else {
            return "broke";
        }

    }
}
