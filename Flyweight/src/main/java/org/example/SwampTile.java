package org.example;

public class SwampTile extends Tile {
    public SwampTile(){
        super("S","swamp",TileImageFactory.getTileImage(TileType.SWAMP));
    }

    @Override
    public void action() {
        System.out.println("swamp tile action");
    }
}
