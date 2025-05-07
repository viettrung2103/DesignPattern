package org.example;

public class MoveCursorDownCommand implements Command {
    private final PixelGrid grid;

    public MoveCursorDownCommand(PixelGrid grid) {
        this.grid = grid;
    }
    @Override
    public void execute() {
        this.grid.moveDown();
    }
}
