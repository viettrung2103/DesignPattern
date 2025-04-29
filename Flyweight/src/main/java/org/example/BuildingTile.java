package org.example;

public class BuildingTile extends Tile {
    public BuildingTile(){
        super("B","building", TileImageFactory.getTileImage(TileType.BUILDING));
    }

    @Override
    public void action() {
        System.out.println("building tile action");
    }

}
