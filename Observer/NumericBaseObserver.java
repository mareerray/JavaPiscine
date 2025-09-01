import java.util.*;

public interface NumericBaseObserver {

    void updateState(int state);

    List<String> getEvents();
}