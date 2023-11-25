package shippingDiscounts.discount;

import shippingDiscounts.product.Product;

public class ChristmasDiscount extends DiscountDecorator {
    private Product p;
    private final double discountRate = 0.2;

    public ChristmasDiscount(Product p) {
        super(p);
        this.p = p;
    }

    public double getWeight() {
        return p.getWeight();
    }

    public double shippingCost() {
        return p.shippingCost() * (1 - discountRate);
    }

    public double totalCost() {
        return p.totalCost() * (1 - discountRate);
    }
}
