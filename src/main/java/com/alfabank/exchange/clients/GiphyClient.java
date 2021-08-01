package com.alfabank.exchange.clients;

import com.alfabank.exchange.clients.dto.giphy.GiphySearchResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${giphy.name}", url = "${giphy.url}")

public interface GiphyClient {


    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/search?api_key=${giphy.apiKey}")
    public GiphySearchResponseDto search(@RequestParam("q") String query);
}
