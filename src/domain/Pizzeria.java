package domain;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pizzeria {
    private Queue<Order> orderQueue;

    public Pizzeria(){
        this.orderQueue = new LinkedList<>();
    }

    public boolean addOrder(Order order){
        return this.orderQueue.add(order);
    }

    public void handleNextOrder(){
        if (orderQueue.size() > 0){
            Order nextOrder = orderQueue.element();
        }
    }
}
