package shippingDiscounts.product;

public class CheapLaptop extends Product {
    private double weight = 0;
    private double price = 0;
    private double shippingRate = 0;
    private String name = "DefaultProduct";

    public CheapLaptop() {
        this.price = (125);
        this.shippingRate = (3);
        this.weight = 2;
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
