package ui;

import domain.Order;
import domain.Person;
import domain.Pizzeria;
import domain.Product;
import domain.strategy.DiscountOverLimit;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Product product = new Product("Pizza Kip", 8.50);
        Person person = new Person("Auraz", "Taher", LocalDate.of(1999,11,12));
        Order order = new Order(person);
        order.setDiscountStrategy(new DiscountOverLimit(7,.5));
        order.addProduct(product);

        Pizzeria pizzeria = new Pizzeria();
        pizzeria.addObserver(person);
        pizzeria.addOrder(order);
        pizzeria.handleNextOrder();

        System.out.println(order.getTotalPrice());
    }

}
