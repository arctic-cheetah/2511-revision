package shippingDiscounts.discount;

import shippingDiscounts.product.Product;

public abstract class DiscountDecorator extends Product {
    private Product p;

    public DiscountDecorator(Product p) {
        this.p = p;
    }

    public abstract double totalCost();

    public abstract double shippingCost();

    public double getWeight() {
        return p.getWeight();
    }

    public double getPrice() {
        return p.getPrice();
    }

    public double getShippingRate() {
        return p.getShippingRate();
    }

    public String getName() {
        return p.getName();
    }

}
