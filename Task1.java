import java.io.*;

public class FileHandler {
    public static void main(String[] args) {
        String filePath = "example.txt";

        // Write to a file
        writeFile(filePath, "Hello, CodTech!");

        // Read from a file
        readFile(filePath);

        // Modify the file
        modifyFile(filePath, "Hello, CodTech!", "Hello, World!");
    }

    // Method to write to a file
    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read from a file
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to modify a file
    public static void modifyFile(String filePath, String oldContent, String newContent) {
        File fileToBeModified = new File(filePath);
        StringBuilder oldContentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified))) {
            String line;
            while ((line = reader.readLine()) != null) {
                oldContentBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String newContentStr = oldContentBuilder.toString().replace(oldContent, newContent);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToBeModified))) {
            writer.write(newContentStr);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
