package shippingDiscounts.product;

public class Laptop extends Product {
    private double weight = 0;
    private double price = 0;
    private double shippingRate = 0;
    private String name = "DefaultProduct";

    public Laptop() {
        this.price = (500);
        this.shippingRate = 2;
        this.weight = (3);
        this.name = ("Laptop");
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getShippingRate() {
        return shippingRate;
    }

    public String getName() {
        return name;
    }
}
