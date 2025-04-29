package org.example;

public abstract class Tile {
    private String character;
    private String description;
    private TileImage tileImage;

    public Tile(String character, String description, TileImage tileImage) {
        this.character = character;
        this.description = description;
        this.tileImage = tileImage;
    }

    public TileImage getTileImage() {
        return this.tileImage;
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

