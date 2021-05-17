package domain.decorator;

public class ToppingSalami extends ToppingDecorator {
    public ToppingSalami(Product product) {
        super(product);
    }

    @Override
    public String getName() {
        return super.product.getName() + "Salami ";
    }

    @Override
    public double getPrice() {
        return super.product.getPrice() + 1.00;
    }
}
