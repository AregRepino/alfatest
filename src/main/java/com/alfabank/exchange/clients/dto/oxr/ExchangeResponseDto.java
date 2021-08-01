package com.alfabank.exchange.clients.dto.oxr;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
public class ExchangeResponseDto implements Serializable {
    private String disclaimer;

    private String license;

    private long timestamp;

    private String base;

    private Map<String, Double> rates;
}
