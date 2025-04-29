package org.example;

import java.util.EnumMap;
import java.util.Map;

public class TileImageFactory {
    private static final Map<TileType,TileImage> images = new EnumMap<>(TileType.class);


    public static TileImage getTileImage(TileType tileType) {
        TileImage tileImage = images.get(tileType);
//        BUILDING, FOREST, ROAD, SWAMP, WATER

        if (tileImage == null) {
            switch (tileType){
                case BUILDING:
                    tileImage =  new TileImage("building.png");
                    break;
                case ROAD:
                    tileImage =  new TileImage("road.png");
                    break;
                case FOREST:
                    tileImage =  new TileImage("forest.png");
                    break;
                case SWAMP:
                    tileImage =  new TileImage("swamp.png");
                    break;
                case WATER:
                    tileImage =  new TileImage("water.png");
                    break;
            }
            images.put(tileType, tileImage);
        }
        return tileImage;
    }
}
