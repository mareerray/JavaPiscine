import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        // Check input file.
        if (args.length < 2) {
            return;
        }

        // Reader & writer.
        FileReader fr = new FileReader(args[0]);
        FileWriter fw = new FileWriter(args[1]);
        BufferedReader reader = new BufferedReader(fr);
        BufferedWriter writer = new BufferedWriter(fw);

        // Split & capitalize & join.
        String line;
        while ((line = reader.readLine()) != null) {
            // remove leading/trailing spaces, reduce multiple spaces to one.
            line = line.trim();

            String[] words = line.split("\\s+"); // Split on any whitespace.

            /* Capitalize each word. */
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (!word.isEmpty()) {
                    word = word.substring(0,1).toUpperCase() +
                            (word.length() > 1 ? word.substring(1).toLowerCase() : "");
                }
                words[i] = word;
            }
            writer.write(String.join(" ", words));
        }
        // Closing.
        reader.close();
        writer.close();
    }
}