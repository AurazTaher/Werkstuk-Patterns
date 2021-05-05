package domain.observer;

public interface Subject {
    boolean addObserver(Observer observer);
    boolean removeObserver(Observer observer);
    void notifyObservers(Object value);
}
