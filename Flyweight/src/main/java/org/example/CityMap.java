package org.example;

public class CityMap extends Map {
    public CityMap() {
        super(MapType.CITY);
    }
    public CityMap(int x, int y) {
        super(MapType.CITY, x, y);
    }

    @Override
    public Tile createTile() {
        int randNum = Utils.getRandomNum();
        switch (randNum) {
            case 0:;
                return new RoadTile();
            case 1:
                return new BuildingTile();
            case 2:
                return new WaterTile();

            default:
                throw new IllegalArgumentException("Unknown tile types " + randNum);
        }
    }
}
