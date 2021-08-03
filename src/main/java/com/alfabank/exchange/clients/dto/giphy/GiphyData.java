package com.alfabank.exchange.clients.dto.giphy;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GiphyData {

    private String id;
    private String url;
    private String bitlyGifUrl;
    private String bitlyUrl;
    private String embedUurl;

}
