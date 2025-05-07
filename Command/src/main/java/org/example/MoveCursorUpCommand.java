package org.example;

public class MoveCursorUpCommand implements Command{
    private final PixelGrid grid;
    public MoveCursorUpCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        this.grid.moveUp();
    }
}
