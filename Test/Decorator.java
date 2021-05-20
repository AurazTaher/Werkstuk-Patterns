import domain.decorator.PlainPizza;
import domain.decorator.Product;
import domain.decorator.ToppingKip;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Decorator {

    @Test
    public void testDecorator(){
        Product product = new ToppingKip(new PlainPizza());
        assertEquals(product.getPrice(),7, 0.0);
        assertEquals(product.getPrepTime(), 12.50,0.00);

    }

}

