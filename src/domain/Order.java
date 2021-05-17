package domain;

import domain.decorator.Product;
import domain.strategy.DiscountStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private double totalPrice;
    private DiscountStrategy discountStrategy;
    private Person orderer;
    private LocalDateTime recievedOrderTime;

    public Order(Person person){
        this.products = new ArrayList<>();
        this.orderer = person;
    }

    public boolean addProduct(Product product){
        if (product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        totalPrice += product.getPrice();
        return this.products.add(product);
    }
    public boolean removeProduct(Product product){
        if (product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        totalPrice -= product.getPrice();
        return this.products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        double discount = 0.0;
        if (discountStrategy != null) discount = discountStrategy.calculateDiscount(this);
        return totalPrice - discount;
    }



    public double getTotalPrepTime(){
        double totalPrepTime = 0.0;

        for (Product product: products) {
        totalPrepTime += product.getPrepTime();
        }

        return totalPrepTime;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public Person getOrderer() {
        return orderer;
    }


    public LocalDateTime getRecievedOrderTime() {
        return recievedOrderTime;
    }

    public void setRecievedOrderTime(LocalDateTime recievedOrderTime) {
        this.recievedOrderTime = recievedOrderTime;
    }
}
