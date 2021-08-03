package com.alfabank.exchange.service;

public class ExchangeUtils {

    public static String buildQueryKeyword(double todayValue, double yesterdayValue) {
        if (todayValue > yesterdayValue) {
            return "rich";
        } else {
            return "broke";
        }
    }
}
