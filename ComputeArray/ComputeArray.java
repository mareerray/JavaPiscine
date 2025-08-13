public class ComputeArray {
    public static int[] computeArray(int[] array) {
        if (array == null) {
            return null;
        }
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int item = array[i];
            switch (item % 3) {
                case 0: // multiple of 3
                    result[i] = item * 5;
                    break;

                case 1: // positive remainder 1
                    result[i] = item + 7;
                    break;

                case 2: // positive remainder 2
                case -1: // negative that behave like remainder 2
                case -2: // negative that behave like remainder 1+1 in positive math
                    result[i] = item;
                    break;
            }
        }
        return result;
    }
}
