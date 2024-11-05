import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        // Check if the input and output file paths are provided
        if (args.length < 2) {
            System.out.println("Usage: java Main <input-file-path> <output-file-path>");
            return;
        }
        String inputFilePath = args[0];
        String outputFilePath = args[1];

        // Read the matches from the input file
        Scanner scanner = new Scanner(new File(inputFilePath));

        // Create a table to store the points for each team
        HashMap<String, Integer> table = new HashMap<>();

        // Process each match and update the table
        while (scanner.hasNextLine()) {

            // Parse the match details
            String match = scanner.nextLine();
            String[] teams = match.split(", ");
            String[] team1Details = teams[0].split(" ");
            String[] team2Details = teams[1].split(" ");
            String team1 = String.join(" ", Arrays.copyOfRange(team1Details, 0, team1Details.length - 1));
            String team2 = String.join(" ", Arrays.copyOfRange(team2Details, 0, team2Details.length - 1));
            int score1 = Integer.parseInt(team1Details[team1Details.length - 1]);
            int score2 = Integer.parseInt(team2Details[team2Details.length - 1]);

            // Update the table based on the match result
            if (score1 > score2) {
                table.put(team1, table.getOrDefault(team1, 0) + 3);
                table.putIfAbsent(team2, table.getOrDefault(team2, 0));
            } else if (score1 < score2) {
                table.put(team2, table.getOrDefault(team2, 0) + 3);
                table.putIfAbsent(team1, table.getOrDefault(team1, 0));
            } else {
                table.put(team1, table.getOrDefault(team1, 0) + 1);
                table.put(team2, table.getOrDefault(team2, 0) + 1);
            }
        }
        scanner.close();
        
        // Sort the table by points in descending order and by team name in ascending order
        List<Map.Entry<String, Integer>> sortedTable = new ArrayList<>(table.entrySet());
        sortedTable.sort((a, b) -> {
            int pointComparison = b.getValue().compareTo(a.getValue());
            if (pointComparison != 0) {
            return pointComparison;
            } else {
            return a.getKey().compareTo(b.getKey());
            }
        });

        // Write the table to the output file
        FileWriter writer = new FileWriter(new File(outputFilePath));
        for (Map.Entry<String, Integer> entry : sortedTable) {
            String points = entry.getValue() == 1 ? "1 pt" : entry.getValue() + " pts";
            writer.write(entry.getKey() + ", " + points + System.lineSeparator());
        }
        writer.close();
    }
}
