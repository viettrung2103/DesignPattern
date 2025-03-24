import java.util.ArrayList;
import java.util.List;

public abstract class Map {
    List<List<Tile>> tileMap;// list of y direction of tiles, each has a list of x direction of tiles
    private MapType mapType;
    private int x;
    private int y;

    public Map(MapType mapType,int x,int y){
        this.tileMap = new ArrayList<List<Tile>>();
        this.mapType = mapType;
        System.out.println("Map of type "+this.mapType+" is created");
        this.x = x;
        this.y = y;
        this.createMap();
//        Tile newTile = createTile();
//        tiles.add(newTile);
    }

    public Map(MapType mapType){
        this(mapType,10,10);
    }

    public void createMap(){
        for (int i = 0 ; i < y; i++){
            List<Tile> newRow = new ArrayList<>();
            for (int j = 0; j < x ; j++){
                Tile newTile = createTile();
                newRow.add(newTile);
            }
            this.tileMap.add(newRow);
        }
    }
    public void display(){
        for (List<Tile>row: tileMap){
            for (Tile tile:row){
                System.out.print(tile.getCharacter()+" ");
            }
            System.out.println();
        }
    }

    public abstract Tile createTile();



}
