
public class BuildingTile extends Tile {
    public BuildingTile(){
        super("B","building");
    }

    @Override
    public void action() {
        System.out.println("building tile action");
    }

}
