package ru.sofia.market;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Throwable {
        //составляем список продуктов
        List<Product> productList = new ArrayList<>();


        LocalDate date = LocalDate.of(2018, 10, 25);


        Money newZeland = new Money(400000, Currency.USD);
        productList.add(new Product("Велингтон", newZeland));

        Money amsterdam = new Money(895000, Currency.EUR);
        productList.add(new Product("Амстердам", amsterdam));

        Money novosibirsk = new Money(4000000, Currency.RUB);
        productList.add(new Product("Новосибирск", novosibirsk));

        double costs = CurrencyService.calculateCosts(productList, Currency.RUB, date);

        System.out.println("Цена всех товаров в рублях: " + String.format("%.2f", costs));
    }

}