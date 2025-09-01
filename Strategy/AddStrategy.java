public class AddStrategy implements OperationStrategy {
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

// The constructor is automatic, so it's not required to define one.