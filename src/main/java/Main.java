import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //составляем список продуктов
        List<Product> productList = new ArrayList<>();


       LocalDate date = new LocalDate(2018, 11, 01);


        Money newZeland = new Money(400000, Currency.USD);
        productList.add(new Product("Велингтон", newZeland));

        Money amsterdam = new Money(895000, Currency.EUR);
        productList.add(new Product("Амстердам", amsterdam));

        Money novosibirsk = new Money(4000000, Currency.RUB);
        productList.add(new Product("Новосибирск", novosibirsk));

        double costs = calculateCosts(productList, Currency.RUB, date);

        System.out.println("Цена всех товаров в рублях: " + String.format("%.2f", costs));
    }


    /**
     * Функция возращают сумму всех товаров в задданой валюте, по текущему курсу
     *
     * @param productList       список продуктов, для которых нужно посчитать стоимость
     * @param costsCurrency     валюта в которой требуется вернуть сумму
     * @param currencyConverter конвертер валют
     * @return
     */

    public static double calculateCosts(List<Product> productList, Currency costsCurrency, LocalDate date){
        CurrencyConverter currencyConverter;
        if (CurrencyBase.contains(date)) {
            currencyConverter = CurrencyBase.get(date);
        } else {
            Reader file = new Reader();
            Double cur[] = file.getCurr(date.toString()+".txt", "src/data/");
            currencyConverter = new CurrencyConverter(cur[0], cur[1], cur[2]);
            CurrencyBase.save(date,currencyConverter);
        }
        double summ = 0;
        for (Product i : productList) {
            System.out.println("product: " + i);
            summ += currencyConverter.convertByCurrency(i.getPrice(), costsCurrency).getValue();
            System.out.println(currencyConverter.convertByCurrency(i.getPrice(), costsCurrency));
        }
        return summ;
    }
}