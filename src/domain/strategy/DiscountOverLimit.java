package domain.strategy;

import domain.Order;
import domain.decorator.Product;


public class DiscountOverLimit extends Discount implements DiscountStrategy {
    private double limit;

    public DiscountOverLimit(double limit, double discountPercentage){
        super(discountPercentage);
        this.setLimit(limit);
    }

    public DiscountOverLimit(double discountPercentage){
        this(0.0,discountPercentage);
    }

    @Override
    public double calculateDiscount(Order order) {
        double totalPriceOfOrder = 0.0;
        for (Product product: order.getProducts()) {
            totalPriceOfOrder += product.getPrice();
        }
        if (totalPriceOfOrder >= limit){
            return totalPriceOfOrder * this.getDiscountPercentage();
        }
        return 0.0;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
