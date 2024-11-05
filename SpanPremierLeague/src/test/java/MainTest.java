import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    @Test
    public void testMain() throws IOException {
        // Create a temporary file with test data
        File tempInputFile = File.createTempFile("test_matches", ".txt");
        FileWriter writer = new FileWriter(tempInputFile);
        writer.write("Lions 3, Snakes 3\n");
        writer.write("Tarantulas 1, FC Awesome 0\n");
        writer.write("Lions 1, FC Awesome 1\n");
        writer.write("Tarantulas 3, Snakes 1\n");
        writer.write("Lions 4, Grouches 0\n");
        writer.close();

        // Create a temporary output file
        File tempOutputFile = File.createTempFile("test_log", ".txt");

        // Redirect the file paths in Main to the temporary files
        String inputFilePath = tempInputFile.getAbsolutePath();
        String outputFilePath = tempOutputFile.getAbsolutePath();
        Main.main(new String[]{inputFilePath, outputFilePath});

        // Verify the results
        Scanner scanner = new Scanner(tempOutputFile);
        assertEquals("Tarantulas, 6 pts", scanner.nextLine());
        assertEquals("Lions, 5 pts", scanner.nextLine());
        assertEquals("FC Awesome, 1 pt", scanner.nextLine());
        assertEquals("Snakes, 1 pt", scanner.nextLine());
        assertEquals("Grouches, 0 pts", scanner.nextLine());
        scanner.close();

        // Clean up the temporary files
        tempInputFile.delete();
        tempOutputFile.delete();
    }

    @Test
    public void testEmptyFile() throws IOException {
        // Create a temporary empty file
        File tempInputFile = File.createTempFile("test_emptyfile_matches", ".txt");

        // Create a temporary output file
        File tempOutputFile = File.createTempFile("test_emptyfile_log", ".txt");

        // Redirect the file paths in Main to the temporary files
        String inputFilePath = tempInputFile.getAbsolutePath();
        String outputFilePath = tempOutputFile.getAbsolutePath();
        Main.main(new String[]{inputFilePath, outputFilePath});

        // Verify the results
        Scanner scanner = new Scanner(tempOutputFile);
        assertEquals(false, scanner.hasNextLine());
        scanner.close();

        // Clean up the temporary files
        tempInputFile.delete();
        tempOutputFile.delete();
    }

    @Test
    public void testSingleMatch() throws IOException {
        // Create a temporary file with a single match
        File tempInputFile = File.createTempFile("test_singlematch_matches", ".txt");
        FileWriter writer = new FileWriter(tempInputFile);
        writer.write("Lions 2, Snakes 1\n");
        writer.close();

        // Create a temporary output file
        File tempOutputFile = File.createTempFile("test_singlematch_log", ".txt");

        // Redirect the file paths in Main to the temporary files
        String inputFilePath = tempInputFile.getAbsolutePath();
        String outputFilePath = tempOutputFile.getAbsolutePath();
        Main.main(new String[]{inputFilePath, outputFilePath});

        // Verify the results
        Scanner scanner = new Scanner(tempOutputFile);
        assertEquals("Lions, 3 pts", scanner.nextLine());
        assertEquals("Snakes, 0 pts", scanner.nextLine());
        scanner.close();

        // Clean up the temporary files
        tempInputFile.delete();
        tempOutputFile.delete();
    }

    @Test
    public void testDrawMatch() throws IOException {
        // Create a temporary file with a draw match
        File tempInputFile = File.createTempFile("test_drawmatch_matches", ".txt");
        FileWriter writer = new FileWriter(tempInputFile);
        writer.write("Lions 2, Snakes 2\n");
        writer.close();

        // Create a temporary output file
        File tempOutputFile = File.createTempFile("test_drawmatch_log", ".txt");

        // Redirect the file paths in Main to the temporary files
        String inputFilePath = tempInputFile.getAbsolutePath();
        String outputFilePath = tempOutputFile.getAbsolutePath();
        Main.main(new String[]{inputFilePath, outputFilePath});

        // Verify the results
        Scanner scanner = new Scanner(tempOutputFile);
        assertEquals("Lions, 1 pt", scanner.nextLine());
        assertEquals("Snakes, 1 pt", scanner.nextLine());
        scanner.close();

        // Clean up the temporary files
        tempInputFile.delete();
        tempOutputFile.delete();
    }
    
    @Test
    public void testFileNotFound() {
        // Provide a non-existent file path
        String inputFilePath = "non_existent_file.txt";
        String outputFilePath = "output_file.txt";

        // Verify that a FileNotFoundException is thrown
        assertThrows(IOException.class, () -> {
            Main.main(new String[]{inputFilePath, outputFilePath});
        });
    }
}
