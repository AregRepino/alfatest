package com.alfabank.exchange.clients.dto.giphy;

import com.alfabank.exchange.clients.dto.giphy.GiphyData;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class GiphySearchResponseDto {
    List<GiphyData> data;
}
