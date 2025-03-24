public class WildernessMap extends Map{
    public WildernessMap(){
        super(MapType.WILDERNESS);
    }
    public WildernessMap(int x, int y){
        super(MapType.WILDERNESS,x,y);
    }

    @Override
    public Tile createTile() {
        int randNum = Utils.getRandomNum();
        switch (randNum){
            case 0:;
                return new RoadTile();
            case 1:
                return new BuildingTile();
            case 2:
                return new WaterTile();
            default:
                throw new IllegalArgumentException("Unknown tile types "+randNum);
        }
    }
}
