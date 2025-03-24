public abstract class Tile {
    private String character;
    private String description;

    public Tile(String character, String description) {
        this.character = character;
        this.description = description;
    }

    public String getCharacter() {
        return this.character;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract void action();

    @Override
    public String toString() {
        return this.character + " " + this.description;
    }
}

