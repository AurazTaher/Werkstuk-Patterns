package domain.decorator;


public class PlainPizza implements Product {

    @Override
    public String getName() {
        return "Plain Pizza ";
    }

    @Override
    public double getPrice() {
        return 5.00;
    }
}
