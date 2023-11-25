package shippingDiscounts.shipping;

import shippingDiscounts.product.Product;

public abstract class FreeShippingDecorator extends Product {
    protected Product p;

    public FreeShippingDecorator(Product p) {
        this.p = p;
    }

    public abstract double totalCost();

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
