import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

class CountryMap {
    private String[] cities;
    private Route[] routes;
    private String startCity;
    private String endCity;

    public static CountryMap loadFromFile(Path filePath) throws IOException {
        Scanner fileScanner = new Scanner(new File(filePath.toString()));
        CountryMap map = new CountryMap();

        // Parse cities
        int numCities = Integer.parseInt(fileScanner.nextLine());
        map.cities = fileScanner.nextLine().split(" ");

        // Parse routes
        int numRoutes = Integer.parseInt(fileScanner.nextLine());
        map.routes = new Route[numRoutes];
        for (int i = 0; i < numRoutes; i++) {
            String[] routeData = fileScanner.nextLine().split(" ");
            String city1 = routeData[0];
            String city2 = routeData[1];
            int time = Integer.parseInt(routeData[2]);
            map.routes[i] = new Route(city1, city2, time);
        }

        // Parse start and end cities
        String[] startEnd = fileScanner.nextLine().split(" ");
        map.startCity = startEnd[0];
        map.endCity = startEnd[1];

        fileScanner.close();
        return map;
    }

    public String[] getCities() {
        return cities;
    }

    public Route[] getRoutes() {
        return routes;
    }

    public String getStartCity() {
        return startCity;
    }

    public String getEndCity() {
        return endCity;
    }
}
