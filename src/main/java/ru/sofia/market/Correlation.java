package ru.sofia.market;

public class Correlation {

  private Currency first;
  private Currency second;
  private double correlation;

  public Correlation(Currency first, Currency second, double correlation) {
    this.first = first;
    this.second = second;
    this.correlation = correlation;
  }

  public Currency getFirstCurrency() {
    return first;
  }

  public Currency getSecondCurrency() {
    return second;
  }

  public double getCorrelation() {

    return correlation;
  }
}
