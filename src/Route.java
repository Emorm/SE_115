class Route {
    private String city1;
    private String city2;
    private int time;

    public Route(String city1, String city2, int time) {
        this.city1 = city1;
        this.city2 = city2;
        this.time = time;
    }

    public String getCity1() {
        return city1;
    }

    public String getCity2() {
        return city2;
    }

    public int getTime() {
        return time;
    }

    public boolean connects(String cityA, String cityB) {
        return (city1.equals(cityA) && city2.equals(cityB)) || (city1.equals(cityB) && city2.equals(cityA));
    }
}
