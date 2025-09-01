import java.util.*;

public class HexaBaseObserver implements NumericBaseObserver {

    // Declare and initialize events:
    private List<String> events = new ArrayList<>();

    // add the hexadecimal String representation of its parameter
    // to the list of events (e.g. for 13, should add "d")
    public void updateState(int state) {
        events.add(Integer.toHexString(state));
    }

    // return the list of events.
    public List<String> getEvents() {
        return events;
    }
}