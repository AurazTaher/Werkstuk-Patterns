import domain.observer.Observer;

public class DummyObserver implements Observer {

    private boolean observerTest;

    public DummyObserver(){
        this.observerTest = false;
    }

    @Override
    public void update(Object value) {
        this.observerTest = true;
    }

    public boolean isObserverTest() {
        return observerTest;
    }
}
