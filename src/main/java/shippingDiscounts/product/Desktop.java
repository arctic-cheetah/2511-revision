package shippingDiscounts.product;

public class Desktop extends Product {
    private double weight = 0;
    private double price = 0;
    private double shippingRate = 0;
    private String name = "DefaultProduct";

    public Desktop() {
        this.price = 1000;
        this.weight = 2;
        this.shippingRate = 5;
        this.name = ("Desktop");
    }

    public double getWeight() {
        return this.weight;
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
