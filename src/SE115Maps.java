import java.io.IOException;
import java.nio.file.Path;

public class SE115Maps {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar SE115Maps.jar <inputFilePath> <outputFilePath>");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        try {
            CountryMap map = CountryMap.loadFromFile(Path.of(inputFileName));

            WayFinder wayFinder = new WayFinder(map);
            String result = wayFinder.findFastestRoute();

            Path outputPath = Path.of(outputFileName);
            java.nio.file.Files.writeString(outputPath, result);

            System.out.println("Fastest route has been written to " + outputPath);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
