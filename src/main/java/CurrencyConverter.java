public class CurrencyConverter {
    private final double unitUSD;
    private final double unitRUB;
    private final double unitEUR;

    public CurrencyConverter(double unitUSD, double unitRUB, double unitEUR) {
        this.unitUSD = unitUSD;
        this.unitRUB = unitRUB;
        this.unitEUR = unitEUR;
    }

    public Money convertByCurrency(Money money, Currency convertToCurrency) {
        //проверяем на совпадение исходной валюты и валюты, в которую конвертируем
        if (money.getMoneyCurrency() != convertToCurrency) {
            //если конвертируемая валюта не равна заданной тогда расчитываем стоимость в заданной валюте

            Money returnMoney = new Money(0, convertToCurrency);
            double unitValue = 0;

            switch (convertToCurrency) {
                case RUB: {
                    unitValue = money.getValue() * unitRUB;
                    break;
                }
                case EUR: {
                    unitValue = money.getValue() * unitEUR;
                    break;
                }
                case USD: {
                    unitValue = money.getValue() * unitUSD;
                    break;
                }
            }

            //записываем вычисленную сумму и возращаем результат
            returnMoney.setValue(unitValue);
            return returnMoney;
        } else {
            //возращаем сумму в исходной валюте т.к. конвертируемая валюта равна исходной
            return money;
        }
    }
}
