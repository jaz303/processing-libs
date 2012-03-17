package com.onehackoranother.processing;

public interface GridWorldDelegate {
    public int getWorldWidth();
    public int getWorldHeight();
    public int getColorForCell(int x, int y);
}
