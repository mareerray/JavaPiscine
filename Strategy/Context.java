public class Context {
    private OperationStrategy operationStrategy;

    // Constructor: initialize operationStrategy with AddStrategy
    public Context() {
        this.operationStrategy = new AddStrategy();
    }

    // Method to change the strategy
    public void changeStrategy (OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    // Executes the current strategy
    public int execute(int a, int b) {
        return operationStrategy.execute(a, b);
    }
}