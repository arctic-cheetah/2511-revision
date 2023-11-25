package shippingDiscounts.product;

public abstract class Product {

    // public Product(double price, double weight, String name) {
    //     this.price = price;
    //     this.weight = weight;
    //     this.name = name;
    // }
    public double shippingCost() {
        return getWeight() * getShippingRate();
    }

    public double totalCost() {
        return getPrice() + shippingCost();
    }

    // Getters and setters below
    public abstract double getWeight();

    public abstract String getName();

    public abstract double getShippingRate();

    public abstract double getPrice();

}
