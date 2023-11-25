package shippingDiscounts.shipping;

import shippingDiscounts.product.Product;

public class FreeShippingOver100 extends FreeShippingDecorator {
    private Product p;
    private double weightThreshold = 0;
    private double priceThreshold = 0;

    public FreeShippingOver100(Product p) {
        super(p);
        this.weightThreshold = (100);
        this.priceThreshold = (5);
        this.p = p;
    }

    /**
    * @pre assume a valid product exists
    * @post return if shipping is free
    * @return
    */
    public boolean isFreeShipping(Product p) {
        boolean passWeight = weightThreshold >= p.getWeight();
        boolean passCost = priceThreshold < p.totalCost();
        return passWeight && passCost;
    }

    private double costWithoutShipping() {
        return p.totalCost() - p.shippingCost();
    }

    public double totalCost() {
        return isFreeShipping(p) ? costWithoutShipping() : p.totalCost();
    }

}
