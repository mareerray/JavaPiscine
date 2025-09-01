import java.util.*;

public class BinaryBaseObserver implements NumericBaseObserver {

    // Declare and initialize events:
    private List<String> events = new ArrayList<>();

    // add the binary String representation of its parameter
    // to the list of events (e.g. for 13, should add "1101")
    public void updateState(int state) {
        events.add(Integer.toBinaryString(state));
    }

    // return the list of events.
    public List<String> getEvents() {
        return events;
    }
}