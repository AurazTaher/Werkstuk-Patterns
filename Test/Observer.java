import domain.Pizzeria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://stackoverflow.com/questions/4713757/unit-testing-for-observer-pattern
public class Observer {


    @Test
    public void testObserver(){
        Pizzeria pizzeria = new Pizzeria();
        DummyObserver dummyObserver = new DummyObserver();
        pizzeria.addObserver(dummyObserver);
        assertEquals(pizzeria.getObservers().size(),1);
        assertEquals(dummyObserver.isObserverTest(),false);
        pizzeria.notifyObservers(null);
        assertEquals(dummyObserver.isObserverTest(), true);

    }

}
