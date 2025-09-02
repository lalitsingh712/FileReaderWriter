import java.io.*;
import java.util.*;

public class FileReadWriteExample {

    public static void main(String[] args) {
        String inputFile = "input.txt";   // Input file name
        String outputFile = "output.txt"; // Output file name

        int lineCount = 0;
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            // Writing results to output file
            writer.write(" File Processing Result\n");
            writer.write("==========================\n");
            writer.write("Total Lines: " + lineCount + "\n");
            writer.write("Total Words: " + wordCount + "\n");

            System.out.println(" File processed successfully!");
            System.out.println(" Results written to " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println(" Error: Input file not found!");
        } catch (IOException e) {
            System.out.println(" Error: An I/O exception occurred.");
        }
    }
}
