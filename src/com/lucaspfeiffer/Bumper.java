package com.lucaspfeiffer;

import processing.core.PApplet;

public class Bumper {

    private PApplet sketch;

    private final float color = 255; //white ball
    private final float bumperWidth = 15;
    private final float bumperHeight = 150;
    private final float bumperSpeed = 8;
    private String side;
    private UI ui;
    private float xPos;
    private float yPos;

    public Bumper(PApplet sketch, UI ui, String side) {
        this.sketch = sketch;
        this.ui = ui;
        this.side = side;
        if (side.equals("left"))
            this.xPos = bumperWidth + 5;
        else
            this.xPos = sketch.width - bumperWidth - 5;
        this.yPos = (float) sketch.height / 2;
    }

    public void move(int action) {
        // 0 = UP, 1 = DOWN
        if (onEdge() == 0) { //not touching edge
            if (action == 0)
                yPos -= bumperSpeed;
            else
                yPos += bumperSpeed;
        }
        else if (onEdge() == 1) //touching top edge
            if (action == 1)
                yPos += bumperSpeed;
            else
                yPos += 1;
        else //touching bottom edge
            if (action == 0)
                yPos -= bumperSpeed;
            else
                yPos -= 1;
    }

    private int onEdge() {
        if (yPos - bumperHeight / 2 < ui.getBorderMargin()) //top border
            return 1; //on top edge
        if (yPos + bumperHeight / 2 > sketch.height - ui.getBorderMargin()) //bottom border
            return 2; //on bottom edge

        return 0; //not on edge
    }

    public void render() {
        sketch.fill(color);
        sketch.rectMode(sketch.CENTER);
        sketch.rect(xPos, yPos, bumperWidth, bumperHeight);
    }
}
