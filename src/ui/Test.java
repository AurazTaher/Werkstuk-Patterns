package ui;

import domain.Order;
import domain.Person;
import domain.Pizzeria;
import domain.decorator.PlainPizza;
import domain.decorator.Product;
import domain.decorator.ToppingKip;
import domain.decorator.ToppingOlijven;
import domain.strategy.DiscountOverLimit;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Product product = new ToppingKip(new ToppingOlijven(new PlainPizza()));
        Person person = new Person("Auraz", "Taher", LocalDate.of(1999,11,12));
        Order order = new Order(person);
        order.setDiscountStrategy(new DiscountOverLimit(7,0));
        order.addProduct(product);

        Pizzeria pizzeria = new Pizzeria();
        pizzeria.addObserver(person);
        pizzeria.addOrder(order);
        pizzeria.handleNextOrder();

        System.out.println(order.getTotalPrice());
    }

}
