package com.onehackoranother.processing;

import processing.core.PApplet;

public class UpdateDrawApplet extends PApplet {
    
    private static final long serialVersionUID = -2318660262937658141L;
    
    private long currentTimestamp;
    private long lastTimestamp;
    
    public long getCurrentTimestamp() { return currentTimestamp; }
    public long getLastTimestamp() { return lastTimestamp; }
    
    public void draw() {
        
        currentTimestamp    = System.currentTimeMillis();
        long delta          = currentTimestamp - lastTimestamp;
        float duration      = (float)delta / 1000.0f;
        
        update(duration);
        render();
        
        lastTimestamp = currentTimestamp;
        
    }
    
    public void update(float delta) {
        
    }
    
    public void render() {
        
    }
}
