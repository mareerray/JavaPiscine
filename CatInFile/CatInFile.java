import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        // Check filename (output).
        if (args.length == 0) {
            return;
        }

        // Open an output file for writing.
        OutputStream output = new FileOutputStream(args[0]);

        // Creat a buffer.
        byte[] buffer = new byte[1024];

        // Reading from standard input & writing to the output file
        int length;
        while ((length = System.in.read(buffer)) != -1) {
            output.write(buffer, 0, length);
        }
        //Close the stream when done
        output.close();
    }
}