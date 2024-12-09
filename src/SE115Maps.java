import java.io.*;
import java.util.*;

public class SE115Maps
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input file name (e.g., map1.txt): ");
        String inputFileName = "src/" + scanner.nextLine();
        System.out.print("Enter the output file name (e.g., output.txt): ");
        String outputFileName = "src/" + scanner.nextLine();

        try
        {
            CountryMap map = CountryMap.loadFromFile(inputFileName);

            WayFinder wayFinder = new WayFinder(map);
            String result = wayFinder.findFastestRoute();

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            writer.write(result);
            writer.close();

            System.out.println("Fastest route has been written to " + outputFileName);
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
