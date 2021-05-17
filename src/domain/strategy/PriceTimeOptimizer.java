package domain.strategy;

import domain.Order;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class PriceTimeOptimizer implements OrderOptimizerStrategy {


    @Override
    public Order getNextOrder(List<Order> orders) {
        if (orders == null || orders.size() == 0) return null;

        Order bestOrder = orders.get(0);

        for (Order order:orders) {
            if (ChronoUnit.MINUTES.between(LocalDateTime.now(),order.getRecievedOrderTime())>20)
                return order;
            if (calculatePriceTime(order) > calculatePriceTime(bestOrder)){
                bestOrder = order;
            }
        }
        return bestOrder;
    }

    private double calculatePriceTime(Order order){
        return order.getTotalPrice()/order.getTotalPrepTime();
    }
}
