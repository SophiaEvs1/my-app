package ru.sofia.market;

/**
 * Класс деньги, содержит значение и валюту
 */
public class Money {
    private double value;

    public void setMoneyCurrency(Currency moneyCurrency) {
        this.moneyCurrency = moneyCurrency;
    }

    private Currency moneyCurrency;
    public Money(double value, Currency moneyCurrency) {
        this.value = value;
        this.moneyCurrency = moneyCurrency;
    }

    public Currency getMoneyCurrency() {
        return moneyCurrency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ru.sofia.market.Money{" +
                "" + value +
                " " + moneyCurrency +
                '}';
    }


}