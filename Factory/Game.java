public class Game {

    private MapType mapType;
    private Map map;
    private int x;
    private int y;
    public static void main (String[] args){
        System.out.println("Hello World");

        Game game = new Game(MapType.CITY);
        System.out.println("new map");
        Game game2 = new Game(MapType.WILDERNESS,5,7);

    }

    public Game(MapType mapType,int x, int y ){
        this.mapType = mapType;
        this.x = x;
        this.y = y;
        this.map =this.createMap();
        this.map.display();
    }

    public Game(MapType mapType){
        this(mapType,0,0); // default size, if x = 0 and y = 0, then size is 10x10
    }


    public Map createMap(){
        System.out.println("Map created");
        switch(mapType){
            case CITY:
                if (x != 0){
                    return new CityMap(x,y);
                }
                return new CityMap();
            case WILDERNESS:
                if (x != 0){
                    return new WildernessMap(x,y);
                }
                return new WildernessMap();
            default:
                throw new IllegalArgumentException("Invalid map type "+mapType);
        }
    }
}
