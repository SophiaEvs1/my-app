package ru.sofia.market;

import java.time.LocalDate;

/**
 * Класс продукт, содержит имя и цену
 */
public class Product {
    private Long id = LocalDate.now().toEpochDay();
    private String productName;
    private Money price;

    public Product() {
        this.productName = "";
        this.price = new Money(0,Currency.RUB);
    }

    public Product(String productName, Money price) {
        this.productName = productName;
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ru.sofia.market.Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

    public String getProductName(){
        return this.productName;
    }

    public void setProductName(String name){
        this.productName = name;
    }

    public Long getId(){
        return this.id;
    }

    public double getPriceValue(){
        return this.price.getValue();
    }

    public void setPriceValue(double value){
        this.price.setValue(value);
    }

    public Currency getPriceCurrency(){
        return this.price.getMoneyCurrency();
    }

    public void setPriceCurrency(Currency value){
        this.price.setMoneyCurrency(value);
    }
}