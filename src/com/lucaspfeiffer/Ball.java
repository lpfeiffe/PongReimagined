package com.lucaspfeiffer;

import processing.core.PApplet;

public class Ball {

    private PApplet sketch;

    private final float color = 255; //white ball
    private float xPos;
    private float yPos;
    private float radius;

    public Ball(PApplet sketch, float radius) {
        this.sketch = sketch;
        this.radius = radius;
        this.xPos = sketch.width/2;
        this.yPos = sketch.height/2 + 100;
    }

    public void move() {
        if (yPos < sketch.height - 30) {
            yPos += 5;
        }
    }

    public void render() {
        sketch.fill(color);
        sketch.circle(xPos, yPos, radius);
    }

}
