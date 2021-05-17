package domain.decorator;

public class ToppingKip extends ToppingDecorator {
    public ToppingKip(Product product) {
        super(product);
    }

    @Override
    public String getName() {
        return super.product.getName() +  "Kip ";
    }

    @Override
    public double getPrice() {
        return super.product.getPrice() + 2.00;
    }

    @Override
    public double getPrepTime() {
        return super.product.getPrepTime() + 5;
    }
}
