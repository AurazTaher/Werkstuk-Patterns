package domain.decorator;

public abstract class ToppingDecorator implements Product {

    protected Product product;
    public ToppingDecorator(Product product){
        this.product = product;
    }

    @Override
    public String getName() {
        return this.product.getName();
    }

    @Override
    public double getPrice() {
        return this.product.getPrice();
    }
}
