package org.example;

public class PixelGrid {
    private final int[][] grid = new int[8][8];
    private int cursorX = 0;
    private int cursorY = 0;

    public void moveUp(){
        if(cursorY > 0){ cursorY--; }
    }
    public void moveDown(){
        if ( cursorY < 7) { cursorY++; }
    }
    public void moveLeft(){
        if(cursorX > 0){ cursorX--; }
    }
    public void moveRight(){
        if(cursorX < 7){ cursorX++; }
    }

    public void toggleCursor(){
        grid[cursorY][cursorX] = grid[cursorY][cursorX] == 0? 1: 0;
    }

    public int[][] getGrid(){
        return grid;
    }
    public int getCursorX(){ return cursorX; }
    public int getCursorY(){ return cursorY; }
}
