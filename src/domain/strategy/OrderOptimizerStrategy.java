package domain.strategy;

import domain.Order;

import java.util.List;

public interface OrderOptimizerStrategy {

    Order getNextOrder(List<Order> orders);

}
