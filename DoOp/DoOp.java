public class DoOp {
    public static String operate(String[] args) {
        // Error check.
        if (args == null || args.length != 3) {
            return "Error";
        }
        // get the value from args by index and declare result.
        // Convert the 1st and 3rd values from String to int.
        int leftNum = Integer.parseInt(args[0]);
        int rightNum = Integer.parseInt(args[2]);
        String operator = args[1];
        int result;

        // Division or modulo by zero check.
        if ((operator.equals("/") || operator.equals("%")) && rightNum == 0) {
            return "Error";
        }

        // Do the calculation.
        if (operator.equals("+")) {
            result = leftNum + rightNum;
        } else if (operator.equals("-")) {
            result = leftNum - rightNum;
        } else if (operator.equals("*")) {
            result = leftNum * rightNum;
        } else if (operator.equals("/")) {
            result = leftNum / rightNum;
        } else if (operator.equals("%")) {
            result = leftNum % rightNum;
        } else {
            return "Error";
        }

        // Return the result as a String.
        return String.valueOf(result);
    }
}