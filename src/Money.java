

/**
 * Класс деньги, содержит значение и валюту
 */
public  class Money {
    public Money(double value, Currency moneyCurrency) {
        this.value = value;
        this.moneyCurrency = moneyCurrency;
    }

    private double value;
    private Currency moneyCurrency;

    public Currency getMoneyCurrency() {
        return moneyCurrency;
    }

    public double getValue(){
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Money{" +
                "" + value +
                " " + moneyCurrency +
                '}';
    }
}