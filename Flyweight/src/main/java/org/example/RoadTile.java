package org.example;

public class RoadTile extends Tile {
    public RoadTile(){
        super("R","road",TileImageFactory.getTileImage(TileType.ROAD));
    }

    @Override
    public void action() {
        System.out.println("road tile action");
    }
}
