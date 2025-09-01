public class ConcatStrategy implements OperationStrategy {
    @Override
    public int execute (int a, int b) {
        // concatenate two integers as strings
        String result = String.valueOf(a) + String.valueOf(b);
        // convert the result back to an int.
        return Integer.parseInt(result);
    }
}