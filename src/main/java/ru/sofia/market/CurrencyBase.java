package ru.sofia.market;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CurrencyBase {
    private static Map<LocalDate, CurrencyConverter> map = new HashMap<>();

    public static void save(LocalDate date, CurrencyConverter converter) {
        map.put(date, converter);
    }

    public static CurrencyConverter get(LocalDate date) {
        return map.get(date);
    }

    public static boolean contains(LocalDate date) {
        return map.containsKey(date);
    }
}
