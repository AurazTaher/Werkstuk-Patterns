package ui;

import domain.Order;
import domain.Person;
import domain.Pizzeria;
import domain.decorator.*;
import domain.strategy.DiscountOverLimit;
import domain.strategy.OrderOptimizerStrategy;
import domain.strategy.PriceTimeOptimizer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        Product product = new ToppingKip(new PlainPizza());
        Product product2 = new ToppingOlijven(new ToppingOlijven(new ToppingOlijven(new ToppingOlijven(new ToppingOlijven(new PlainPizza())))));
        Person person = new Person("Auraz", "Taher", LocalDate.of(1999,11,12));
        Order order = new Order(person);
        Order order2 = new Order(person);
        order.addProduct(product);
        order2.addProduct(product2);

        OrderOptimizerStrategy orderOptimizerStrategy = new PriceTimeOptimizer();

        Pizzeria pizzeria = new Pizzeria();
        pizzeria.addObserver(person);
        pizzeria.addOrder(order);
        pizzeria.addOrder(order2);

        order.setRecievedOrderTime(LocalDateTime.of(2021, 5, 17, 23,30 ));


        pizzeria.setOrderOptimizerStrategy(orderOptimizerStrategy);
        pizzeria.handleNextOrder();


        System.out.println(product.getPrepTime());
    }

}
