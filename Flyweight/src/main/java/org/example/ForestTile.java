package org.example;

public class ForestTile extends Tile {
    public ForestTile(){
        super("R","road",TileImageFactory.getTileImage(TileType.FOREST));
    }

    @Override
    public void action() {
        System.out.println("road tile action");
    }
}
