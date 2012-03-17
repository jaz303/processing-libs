package com.onehackoranother.processing;

import processing.core.PGraphics;

public class GridWorld {
    private GridWorldDelegate   delegate    = null;
    private int                 cellSize    = 20;
    private int                 cellSpacing = 1;
    private int                 x           = 0;
    private int                 y           = 0;
    private PGraphics           graphics    = null;
    
    public GridWorldDelegate getDelegate() { return delegate; }
    public void setDelegate(GridWorldDelegate d) { delegate = d; }
    
    public int getWidth() { return (delegate.getWorldWidth() * (cellSize + cellSpacing)) - cellSpacing; }
    public int getHeight() { return (delegate.getWorldHeight() * (cellSize + cellSpacing)) - cellSpacing; }
    
    public int getCellSize() { return cellSize; }
    public void setCellSize(int cs) { cellSize = cs; }
    
    public int getCellSpacing() { return cellSpacing; }
    public void setCellSpacing(int s) { cellSpacing = s; }
    
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    
    public void setPos(int x, int y) { this.x = x; this.y = y; }
    
    public PGraphics getGraphics() { return graphics; }
    public void setGraphics(PGraphics g) { graphics = g; }
    
    public void draw() {
        int currX = x;
        int currY = y;
        int width = delegate.getWorldWidth();
        int height = delegate.getWorldHeight();
        
        graphics.noStroke();
        
        for (int i = 0; i < width; i++) {
            currY = y;
            for (int j = 0; j < height; j++) {
                graphics.fill(delegate.getColorForCell(i, j));
                graphics.rect(currX, currY, cellSize, cellSize);
                currY += cellSize + cellSpacing;
            }
            currX += cellSize + cellSpacing;
        }
    }
    
    public void highlightCell(int x, int y, int color) {
        graphics.fill(color);
        graphics.rect(this.x + (x * (cellSize + cellSpacing)),
                      this.y + (y * (cellSize + cellSpacing)),
                      cellSize,
                      cellSize);
    }
}
