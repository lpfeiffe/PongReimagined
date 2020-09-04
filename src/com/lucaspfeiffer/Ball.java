package com.lucaspfeiffer;

import processing.core.PApplet;

public class Ball {

    private PApplet sketch;

    private final float color = 255; //white ball
    private final float ballSpeed = 5;
    private float xPos;
    private float yPos;
    private float radius;
    private UI ui;
    public boolean firstMove;
    private double theta;

    public Ball(PApplet sketch, UI ui, float radius) {
        this.sketch = sketch;
        this.ui = ui;
        this.radius = radius;
        this.xPos = (float) sketch.width / 2;
        this.yPos = (float) sketch.height / 2;
        this.firstMove = true;
    }

    public void move() {
        if (firstMove) {
            xPos = (float) sketch.width / 2;
            yPos = (float) sketch.height / 2;
            theta = Math.asin((float) ((sketch.height / 2) / (sketch.width / 2)));
            theta *= sketch.random(2);
            //select a random position to start from
            if (sketch.random(2) < 0.5) { // 0 = left, 1 = right
                if (sketch.random(2) < 0.5) { // 0 = top, 1 = bottom
                    xPos -= ballSpeed;
                    yPos -= (ballSpeed * Math.tan(theta));
                } else { //bottom left
                    xPos -= ballSpeed;
                    yPos += (ballSpeed * Math.tan(theta));
                }
            } else {
                if (sketch.random(2) < 0.5) { // top right
                    xPos += ballSpeed;
                    yPos -= (ballSpeed * Math.tan(theta));
                } else { //bottom right
                    xPos += ballSpeed;
                    yPos += (ballSpeed * Math.tan(theta));
                }
            }
            firstMove = false;
        } else {
            xPos += ballSpeed;
            yPos += ballSpeed;
        }
    }

    public void render() {
        sketch.fill(color);
        sketch.circle(xPos, yPos, radius);
    }

}
