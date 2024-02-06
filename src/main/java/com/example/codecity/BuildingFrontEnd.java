package com.example.codecityjavafx;

import javafx.scene.paint.Color;

public class BuildingFrontEnd  {
    private final int x;
    private final int y;
    private final Color color;
    private final int height;

    public BuildingFrontEnd(int x, int y, Color c, int height) {
        this.x = x;
        this.y = y;
        this.color = c;
        this.height = height;
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public Color getColor() {return color;}

    public int getHeight() {return height;}
}
