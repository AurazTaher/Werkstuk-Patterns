package domain.strategy;

import domain.Order;
import domain.Product;

public class TotalDiscount extends Discount implements DiscountStrategy {

    public TotalDiscount(double discountPercentage){
        super(discountPercentage);
    }

    @Override
    public double calculateDiscount(Order order) {
        double totalPriceOfOrder = 0.0;
        for (Product product: order.getProducts()) {
            totalPriceOfOrder += product.getPrice();
        }
        return totalPriceOfOrder * getDiscountPercentage();
    }
}
