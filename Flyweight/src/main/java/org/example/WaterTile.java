package org.example;

public class WaterTile extends Tile {
    public WaterTile(){
        super("W","water",TileImageFactory.getTileImage(TileType.WATER));
    }

    @Override
    public void action() {
        System.out.println("water tile action");
    }
}
