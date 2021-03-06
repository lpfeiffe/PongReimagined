package com.lucaspfeiffer;

import processing.core.PApplet;

public class Ball {

    private PApplet sketch;

    private final float color = 255; //white ball
    private final float hitCountMax = 5;
    private float xVel = 0;
    private float yVel = 0;
    private float vSpeed = 100;
    private float xPos;
    private float yPos;
    private float dt = 0.10F;
    private float radius;
    private UI ui;
    private int hitCount = 0;

    public Ball(PApplet sketch, UI ui, float radius) {
        this.sketch = sketch;
        this.ui = ui;
        this.radius = radius;
        this.xPos = (float) sketch.width / 2;
        this.yPos = (float) sketch.height / 2;

        double angle = calcRandomAngle();
        xVel = (float)(vSpeed * Math.cos(angle));
        yVel = (float)(vSpeed * Math.sin(angle));
    }

    public void move(Bumper left, Bumper right) {
        xPos += xVel * dt;
        yPos += yVel * dt;

        if (yPos > (sketch.height - ui.getBorderMargin())) yVel *= -1;
        if (yPos < ui.getBorderMargin()) yVel *= -1;
        if ((xPos - radius < left.getxPos()) && (Math.abs(yPos - left.getyPos()) < left.getBumperHeight()/2)) {
            xVel *= -1;
            updateHitCount();
            if (hitCount == hitCountMax) {
                dt += 0.025F;
                System.out.println("updated dt");
            }
        }
        if ((xPos + radius > right.getxPos()) && (Math.abs(yPos - right.getyPos()) < right.getBumperHeight()/2)) {
            xVel *= -1;
            updateHitCount();
            if (hitCount == hitCountMax) {
                dt += 0.025F;
                System.out.println("updated dt");
            }
        }
    }

    public int ballOut() {
        if (xPos < ui.getBorderMargin()) return -1;
        if (xPos > sketch.width - ui.getBorderMargin()) return 1;
        return 0;
    }

    private double calcRandomAngle() {
        double angle = sketch.random((float) (Math.PI/4 * -1),(float) (Math.PI/4));
        if (sketch.random(-1, 1) < 0.0) angle += Math.PI;
        return angle;
    }

    public void render() {
        sketch.fill(color);
        sketch.circle(xPos, yPos, radius);
    }

    public void updateHitCount() {
        hitCount = hitCount + 1;
        if (hitCount > hitCountMax) hitCount = 0;
    }

    public void resetHitCount() {
        hitCount = 0;
        dt = 0.10F;
        System.out.println("reset");
    }
}
