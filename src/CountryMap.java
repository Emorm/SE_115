import java.io.*;
import java.util.*;

class CountryMap {
    private List<String> cities = new ArrayList<>();
    private List<Route> routes = new ArrayList<>();
    private String startCity;
    private String endCity;

    public static CountryMap loadFromFile(String fileName) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        CountryMap map = new CountryMap();


        int numCities = Integer.parseInt(br.readLine());
        String[] cityLabels = br.readLine().split(" ");
        map.cities.addAll(Arrays.asList(cityLabels));


        int numRoutes = Integer.parseInt(br.readLine());
        for (int i = 0; i < numRoutes; i++) {
            String[] routeData = br.readLine().split(" ");
            String city1 = routeData[0];
            String city2 = routeData[1];
            int time = Integer.parseInt(routeData[2]);
            map.routes.add(new Route(city1, city2, time));
        }


        String[] startEnd = br.readLine().split(" ");
        map.startCity = startEnd[0];
        map.endCity = startEnd[1];

        br.close();
        return map;
    }

    public List<String> getCities() {
        return cities;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public String getStartCity() {
        return startCity;
    }

    public String getEndCity() {
        return endCity;
    }
}
