import domain.Order;
import domain.Person;
import domain.Pizzeria;
import domain.decorator.PlainPizza;
import domain.decorator.Product;
import domain.decorator.ToppingKip;
import domain.decorator.ToppingOlijven;
import domain.strategy.*;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class Strategy {

    @Test
    public void testDiscountTotal(){
        Person person = new Person("Auraz", "Taher", LocalDate.of(1999,11,12));
        Order order = new Order(person);
        Product product = new ToppingKip(new PlainPizza());
        order.addProduct(product);
        DiscountStrategy discountStrategy = new TotalDiscount(0.50);
        order.setDiscountStrategy(discountStrategy);
        assertEquals(order.getTotalPrice(), 3.5, 0.00);
    }

    @Test
    public void testDiscountOverLimit(){
        Person person = new Person("Auraz", "Taher", LocalDate.of(1999,11,12));
        Order order = new Order(person);
        Product product = new ToppingOlijven(new ToppingKip(new PlainPizza()));
        order.addProduct(product);
        DiscountStrategy discountStrategy = new DiscountOverLimit(7,0.50);
        order.setDiscountStrategy(discountStrategy);
        assertEquals(order.getTotalPrice(), 3.75, 0.00);
    }

    @Test
    public void testDiscountOverLimitFail(){
        Person person = new Person("Auraz", "Taher", LocalDate.of(1999,11,12));
        Order order = new Order(person);
        Product product = new PlainPizza();
        order.addProduct(product);
        DiscountStrategy discountStrategy = new DiscountOverLimit(7,0.50);
        order.setDiscountStrategy(discountStrategy);
        assertEquals(order.getTotalPrice(), 5, 0.00);
    }

    @Test
    public void testOptimizer(){
        Product product = new ToppingKip(new PlainPizza());
        Product product2 = new ToppingOlijven(new ToppingOlijven(new ToppingOlijven(new ToppingOlijven(new ToppingOlijven(new PlainPizza())))));
        Person person = new Person("Auraz", "Taher", LocalDate.of(1999,11,12));
        Order order = new Order(person);
        Order order2 = new Order(person);
        order.addProduct(product);
        order2.addProduct(product2);
        Pizzeria pizzeria = new Pizzeria();
        OrderOptimizerStrategy orderOptimizerStrategy = new PriceTimeOptimizer();
        pizzeria.addOrder(order);
        pizzeria.addOrder(order2);
        pizzeria.setOrderOptimizerStrategy(orderOptimizerStrategy);
        pizzeria.handleNextOrder();
        assertEquals(pizzeria.getOrders().get(0),order);
    }

}
