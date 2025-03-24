public class SwampTile extends Tile{
    public SwampTile(){
        super("S","swamp");
    }

    @Override
    public void action() {
        System.out.println("swamp tile action");
    }
}
