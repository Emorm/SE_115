import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class SE115Maps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input file name (e.g., map1.txt): ");
        String inputFileName = scanner.nextLine();
        System.out.print("Enter the output file name (e.g., output.txt): ");
        String outputFileName = scanner.nextLine();

        try {
            // Load the map
            CountryMap map = CountryMap.loadFromFile(Path.of("src", inputFileName));

            // Find the fastest route using brute-force
            WayFinder wayFinder = new WayFinder(map);
            String result = wayFinder.findFastestRoute();

            // Write the result to the output file
            Path outputPath = Path.of("src", outputFileName);
            java.nio.file.Files.writeString(outputPath, result);

            System.out.println("Fastest route has been written to " + outputPath);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
