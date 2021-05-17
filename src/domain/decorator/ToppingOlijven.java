package domain.decorator;

public class ToppingOlijven extends ToppingDecorator {
    public ToppingOlijven(Product product) {
        super(product);
    }

    @Override
    public String getName() {
        return super.product.getName() +  "Olijf ";
    }

    @Override
    public double getPrice() {
        return super.product.getPrice() + 0.50;
    }
}
