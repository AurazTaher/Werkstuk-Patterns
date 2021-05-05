package domain.strategy;

import domain.Order;

public interface DiscountStrategy {
    double calculateDiscount(Order order);
}
