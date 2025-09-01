import java.util.*;

public class DecimalBaseObserver implements NumericBaseObserver {

    // Declare and initialize events:
    private List<String> events = new ArrayList<>();

    // add the decimal String representation of its parameter
    // to the list of events (e.g. for 13, should add "13")
    public void updateState(int state) {
        events.add(String.valueOf(state));
        // Convert using String.valueOf(state)
        // or Integer.toString(state) when adding to the list.
    }

    // return the list of events.
    public List<String> getEvents() {
        return events;
    }
}