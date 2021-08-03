package com.alfabank.exchange.clients.dto.giphy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class GiphySearchResponseDto {
    List<GiphyData> data;
}
