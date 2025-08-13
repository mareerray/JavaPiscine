import java.io.*;

public class FileSearch {
    public static String searchFile(String fileName) {
        // Start from the "document" folder at the root.
        File rootFolder = new File("documents");

        // Start searching.
        String result = searchInFolder(rootFolder, fileName);
        return result;
    }

    // Helper function to search inside a folder (and its subfolders)
    private static String searchInFolder(File folder, String fileName) {
        // Check if a file or directory exists.
        if (!folder.exists() || !folder.isDirectory()) return null;

        File[] files = folder.listFiles();

        if (files == null) return null;

        for (File file : files) {
            if (file.isFile() && file.getName().equals(fileName)) {
                // Found the file, return its path relative to 'documents'.
                // Replace backslash with slash for consistency.
                return file.getPath().replace("\\", "/");
            } else if (file.isDirectory()) {
                // Recursively search inside subfolders
                String found = searchInFolder(file, fileName);
                if (found != null) return found;
            }
        }
        // File not found in this folder or its subfolders
        return null;
    }
}