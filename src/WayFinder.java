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
        String[] visited = new String[map.getCities().length];
        explore(map.getStartCity(), visited, 0, 0);

        if (shortestPath.isEmpty())
        {
            return "No path exists between " + map.getStartCity() + " and " + map.getEndCity();
        }

        return "Fastest Way: " + shortestPath + "\nTotal Time: " + shortestTime + " mins";
    }

    private void explore(String currentCity, String[] visited, int visitCount, int currentTime)
    {
        visited[visitCount] = currentCity;
        visitCount++;

        if (currentCity.equals(map.getEndCity()))
        {
            if (currentTime < shortestTime)
            {
                shortestTime = currentTime;
                shortestPath = String.join(" -> ", visited).trim();
            }
        } else
        {
            for (Route route : map.getRoutes())
            {
                String neighbor = null;
                if (route.getCity1().equals(currentCity) && !isVisited(route.getCity2(), visited, visitCount))
                {
                    neighbor = route.getCity2();
                } else if (route.getCity2().equals(currentCity) && !isVisited(route.getCity1(), visited, visitCount)) {
                    neighbor = route.getCity1();
                }

                if (neighbor != null)
                {
                    explore(neighbor, visited.clone(), visitCount, currentTime + route.getTime());
                }
            }
        }
    }

    private boolean isVisited(String city, String[] visited, int visitCount)
    {
        for (int i = 0; i < visitCount; i++)
        {
            if (visited[i].equals(city))
            {
                return true;
            }
        }
        return false;
    }
}
