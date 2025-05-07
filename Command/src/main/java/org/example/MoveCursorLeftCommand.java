package org.example;

public class MoveCursorLeftCommand implements Command {
    private final PixelGrid grid;
    public MoveCursorLeftCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        this.grid.moveLeft();
    }
}
