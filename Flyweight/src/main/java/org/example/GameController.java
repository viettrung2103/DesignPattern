package org.example;

import javafx.scene.image.Image;

public class GameController {
    private Map map;

    public GameController(MapType mapType, int x, int y){
        if (x == 0 && y == 0){
            this.map = createMap(mapType);
        } else {
            this.map = createMap(mapType, x,y);
        }
    }
    public GameController(MapType mapType){
        this(mapType, 0, 0);
    }
    public Map getMap(){
        return map;
    }

    public Image getTileImage(int row, int col){
        return map.getTileImage(row,col).getImage();
    }

    public int getMapWidth(){
        return map.getWidth();
    }

    public int getMapHeight(){
        return map.getHeight();
    }

    private Map createMap(MapType mapType){
        switch (mapType){
            case CITY -> {return new CityMap();}
            case WILDERNESS -> {return new WildernessMap();}
            default -> throw new IllegalArgumentException("Invalid map type "+mapType);

        }
    }

    private Map createMap(MapType mapType, int x, int y){
        switch (mapType){
            case CITY -> { return new CityMap(x, y);}
            case WILDERNESS ->  {return new WildernessMap(x, y);}
            default -> throw new IllegalArgumentException("Invalid map type "+mapType);
        }
    }
}