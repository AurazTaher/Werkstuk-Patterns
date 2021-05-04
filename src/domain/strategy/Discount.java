package domain.strategy;

public abstract class Discount {
    protected double discountPercentage;

    public Discount(double discountPercentage){
        this.setDiscountPercentage(discountPercentage);
    }

    public double getDiscountPercentage() {
        if (this.discountPercentage >= 0.0 && this.discountPercentage <= 1.0){
            return discountPercentage;
        }
        else {
            return this.discountPercentage / 100;
        }
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
