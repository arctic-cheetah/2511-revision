package shippingDiscounts.discount;

import shippingDiscounts.product.Product;

public class MemberDeal extends DiscountDecorator {
    Product p;
    private final double discountRate = 0.05;

    public MemberDeal(Product p) {
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
