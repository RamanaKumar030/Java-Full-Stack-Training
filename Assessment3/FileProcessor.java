package DAY3;

import java.io.*;

// Custom exception for empty file
class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

public class FileProcessor {
    public static void main(String[] args) {
        String filePath = "data.txt"; // Ensure this file exists

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            if (line == null) {
                throw new EmptyFileException("File is empty!");
            }
            System.out.println("File Content: ");
            do {
                System.out.println(line);
                line = br.readLine();
            } while (line != null);

        } catch (EmptyFileException e) {
            System.out.println("Custom Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}

