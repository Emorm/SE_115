import java.util.*;

class WayFinder
{
    private CountryMap map;
    private int shortestTime = Integer.MAX_VALUE;
    private String shortestPath = "";

    public WayFinder(CountryMap map)
    {
        this.map = map;
    }

    public String findFastestRoute()
    {
        List<String> visited = new ArrayList<>();
        explore(map.getStartCity(), visited, 0);

        if (shortestPath.isEmpty())
        {
            return "No path exists between " + map.getStartCity() + " and " + map.getEndCity();
        }

        return "Fastest Way: " + shortestPath + "\nTotal Time: " + shortestTime + " mins";
    }

    private void explore(String currentCity, List<String> visited, int currentTime) {
        visited.add(currentCity);

        if (currentCity.equals(map.getEndCity()))
        {
            if (currentTime < shortestTime)
            {
                shortestTime = currentTime;
                shortestPath = String.join(" -> ", visited);
            }
        }
        else
        {

            for (Route route : map.getRoutes())
            {
                String neighbor = null;
                if (route.getCity1().equals(currentCity) && !visited.contains(route.getCity2()))
                {
                    neighbor = route.getCity2();
                } else if (route.getCity2().equals(currentCity) && !visited.contains(route.getCity1()))
                {
                    neighbor = route.getCity1();
                }

                if (neighbor != null)
                {
                    explore(neighbor, new ArrayList<>(visited), currentTime + route.getTime());
                }
            }
        }

        visited.remove(currentCity);
    }
}
