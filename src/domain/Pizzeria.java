package domain;



import domain.observer.Observer;
import domain.observer.Subject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pizzeria implements Subject {
    private Queue<Order> orderQueue;
    private List<Observer> observers;

    public Pizzeria(){
        this.orderQueue = new LinkedList<>();
        this.observers = new ArrayList<>();
    }

    public boolean addOrder(Order order){
        return this.orderQueue.add(order);
    }

    public void handleNextOrder(){
        if (orderQueue.size() > 0){
            Order nextOrder = orderQueue.element();
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
}
