import java.io.*;

public class FileManager {
    // Create a file and write content.
    public static void createFile(String fileName, String content) throws IOException {
        FileWriter writer = new FileWriter(fileName); // Open a file.
        writer.write(content);  // Write the given content.
        writer.close();  // Close the file to save changes.
    }

    // Get content from a file.
    public static String getContentFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {  // Read each line from the file.
            sb.append(line);  // Add it to a string.
            sb.append(System.lineSeparator());  // Keep line breaks.
        }
        reader.close();
        return sb.toString().trim();  // Return the text and remove last line break.
    }

    // Delete a file.
    public static void deleteFile(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {  // Check if the file exists.
            boolean deleted = file.delete();  // Try to delete and store the result.

            if (deleted) {
                System.out.println("File deleted successfully: " + fileName);
            } else {
                System.out.println("Failed to delete file: " + fileName);
            }
        } else {
            System.out.println("File not found: " + fileName);
        }
    }
}