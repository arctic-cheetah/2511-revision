package shippingDiscounts;

import shippingDiscounts.discount.ChristmasDiscount;
import shippingDiscounts.discount.MemberDeal;
import shippingDiscounts.product.Laptop;
import shippingDiscounts.product.Product;
import shippingDiscounts.shipping.FreeShippingOver100;

public class ShoppingCart {
    public static void main(String[] args) {
        // Laptop Cost is 500 + $6 shipping
        Product p = new Laptop();
        p = new ChristmasDiscount(p);
        p = new MemberDeal(p);

        System.out.println(p.totalCost());
        // No bugs here because we're referencing p in a chain
        p = new FreeShippingOver100(p);
        System.out.println(p.totalCost());

        // You can apply free shipping again as we are p inside a linear chain
        // Not expected behaviour
        // To prevent this behaviour you must prevent the user from calling freeShippingtwice here in the shopping cart
        Product afterWards = new FreeShippingOver100(p);
        System.out.println(afterWards.totalCost());

    }
}
