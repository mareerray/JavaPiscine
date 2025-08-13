public class SortArgs {
    public static void sort(String[] args) {
        // Convert String[] to int[].
        int[] arrayInt = new int[args.length];

        // Loop through args array.
        for (int i = 0; i < args.length; i++) {
            // Convert each String number to an actual int and assign to int[].
            arrayInt[i] = Integer.parseInt(args[i]);
        }

        // Sort the numbers from smallest to biggest using insertion sort.
        for (int i = 1; i < arrayInt.length; i++) {
            int current = arrayInt[i]; // Store the current elment.
            int j = i-1;
            // Move elements bigger than current to one position to the right.
            while (j >= 0 && arrayInt[j] > current) {
                arrayInt[j+1] = arrayInt[j];
                j--;
            }
            arrayInt[j+1] = current; // Place current in its correct spot.
        }

        // print each number separated by spaces using for-loop
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print(arrayInt[i]);
            if ( i < arrayInt.length - 1) {
                System.out.print(" "); // Add space between numbers.
            }
        }
        // End with a new line.
        System.out.print("\n");
    }
}