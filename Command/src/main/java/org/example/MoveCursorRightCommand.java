package org.example;

public class MoveCursorRightCommand implements Command {

    private final PixelGrid grid;
    public MoveCursorRightCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
     this.grid.moveRight();
    }
}
