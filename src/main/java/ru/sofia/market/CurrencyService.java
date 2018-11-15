package ru.sofia.market;

import java.time.LocalDate;
import java.util.List;

public class CurrencyService {
    public static CurrencyConverter getConverter(LocalDate date) throws Throwable {
        CurrencyConverter currencyConverter;
        if (CurrencyBase.contains(date)) {
            currencyConverter = CurrencyBase.get(date);
        } else {
            Reader file = new Reader();
            currencyConverter = file.getCurr(date.toString() + ".txt", "src/main/resources/data/");
            if (currencyConverter == null)
                currencyConverter = file.getCurrencies_from_site(date.toString() + ".txt", "src/main/resources/data/", date);
            CurrencyBase.save(date, currencyConverter);
        }

        return currencyConverter;
    }

    public static double calculateCosts(List<Product> productList, Currency costsCurrency, LocalDate date) throws Throwable {
        CurrencyConverter currencyConverter = CurrencyService.getConverter(date);
        double summ = 0;
        for (Product i : productList) {
            System.out.println("product: " + i);
            summ += currencyConverter.convertByCurrency(i.getPrice(), costsCurrency).getValue();
            System.out.println(currencyConverter.convertByCurrency(i.getPrice(), costsCurrency));
        }
        return summ;
    }
}
