package org.example;

public class TogglePixelCommand implements Command {
    private final PixelGrid grid;
    public TogglePixelCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.toggleCursor();
    }
}

