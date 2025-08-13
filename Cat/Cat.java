import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        // Check for input filename.
        if (args.length == 0) {
            return;
        }
        // Open it so you can read it.
        InputStream input = new FileInputStream(args[0]);

        // Buffer for reading small chunks.
        byte[] buffer = new byte[1024];

        // Read and print each chunk in a loop.
        int length;
        while ((length = input.read(buffer)) != -1) {
            System.out.write(buffer, 0, length);
        }

        // Close the stream when done.
        input.close();
    }
}