import java.util.*;

public class ValuePublisher {
    // -List~NumericBaseObserver~ observers in your diagram means the field should be of type
    // List<NumericBaseObserver>, and you will typically use an ArrayList to create it in Java.
    private List<NumericBaseObserver> observers = new ArrayList<>();

    // Loop Through List and notify all registered observers.
    public void updateState(int value) {
        for (NumericBaseObserver observer : observers) {
            observer.updateState(value);
        }
    }

    // add the observer to the list of observers.
    public void subscribe (NumericBaseObserver observer) {
        observers.add(observer);
    }

    // remove the observer from the list of observers.
    public void unsubscribe (NumericBaseObserver observer) {
        observers.remove(observer);
    }
}