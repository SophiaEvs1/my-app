/**
 * Класс продукт, содержит имя и цену
 */
public class Product {
    private String productName;
    private Money price;

    protected Product(String productName, Money price) {
        this.productName = productName;
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}