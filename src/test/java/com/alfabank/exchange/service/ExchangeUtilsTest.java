package com.alfabank.exchange.service;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExchangeUtilsTest {

    @Test
    public void buildQueryKeywordWithRich() {
        //when
        String actual = ExchangeUtils.buildQueryKeyword(2, 1);

        //then
        assertEquals("rich", actual);
    }

    @Test
    public void buildQueryKeywordWithBroke() {
        //when
        String actual = ExchangeUtils.buildQueryKeyword(1, 2);

        //then
        assertEquals("broke", actual);
    }


    @Test
    public void buildQueryKeywordEqualBroke() {
        //when
        String actual = ExchangeUtils.buildQueryKeyword(1, 1);

        //then
        assertEquals("broke", actual);
    }


}
