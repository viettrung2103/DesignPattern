public class WaterTile extends Tile{
    public WaterTile(){
        super("W","water");
    }

    @Override
    public void action() {
        System.out.println("water tile action");
    }
}
