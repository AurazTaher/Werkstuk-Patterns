package domain;



import domain.observer.Observer;
import domain.observer.Subject;
import domain.strategy.OrderOptimizerStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pizzeria implements Subject {
    private List<Order> orders;
    private List<Observer> observers;
    private int amountOfPizza;
    private OrderOptimizerStrategy orderOptimizerStrategy;

    public Pizzeria(){
        this.orders = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.amountOfPizza = 200;
    }

    public boolean addOrder(Order order){
        order.setRecievedOrderTime(LocalDateTime.now());
        return this.orders.add(order);
    }

    public void handleNextOrder(){
        if (orders.size() > 0){
            Order nextOrder = this.orderOptimizerStrategy.getNextOrder(orders);
            this.notifyObservers(nextOrder);
        }
    }

    @Override
    public boolean addObserver(Observer observer) {
        if (observer == null){
            throw new IllegalArgumentException("Observer cannot be null");
        }
        return this.observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        if (observer == null){
            throw new IllegalArgumentException("Observer cannot be null");
        }
        return this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(Object value) {
        for (Observer observer: this.observers) {
            observer.update(value);
        }
    }

    public int getAmountOfPizza() {
        return amountOfPizza;
    }

    public void setAmountOfPizza(int amountOfPizza) {
        this.amountOfPizza = amountOfPizza;
    }

    public OrderOptimizerStrategy getOrderOptimizerStrategy() {
        return orderOptimizerStrategy;
    }

    public void setOrderOptimizerStrategy(OrderOptimizerStrategy orderOptimizerStrategy) {
        this.orderOptimizerStrategy = orderOptimizerStrategy;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
