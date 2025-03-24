public class ForestTile extends Tile {
    public ForestTile(){
        super("R","road");
    }

    @Override
    public void action() {
        System.out.println("road tile action");
    }
}
