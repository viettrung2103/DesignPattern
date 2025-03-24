public class RoadTile extends Tile{
    public RoadTile(){
        super("R","road");
    }

    @Override
    public void action() {
        System.out.println("road tile action");
    }
}
