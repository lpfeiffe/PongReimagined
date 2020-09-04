package com.lucaspfeiffer;

import processing.core.PApplet;

public class UI {

    private PApplet sketch;

    private final float borderMargin = 30;
    private final int titleSize = 64;
    private final int subTitleSize = 22;


    public UI (PApplet sketch) {
        this.sketch = sketch;
    }

    public void displayStartScreen() {
        drawBorder();
        displayTitle("PONG REIMAGINED", (float)sketch.width/2, (float)sketch.height/3);
        displaySubTitle("Click anywhere to begin", (float)sketch.width/2, (float)sketch.height/3 + 50);

    }

    public void displayLevel1() {
        drawBorder();
    }

    private void displayTitle(String string, float xPos, float yPos) {
        sketch.textSize(titleSize);
        sketch.textAlign(sketch.CENTER);
        sketch.text(string, xPos, yPos);
    }

    private void displaySubTitle(String string, float xPos, float yPos) {
        sketch.textSize(subTitleSize);
        sketch.textAlign(sketch.CENTER);
        sketch.text(string, xPos, yPos);
    }

    public void drawBorder() {
        sketch.strokeWeight(2);
        sketch.stroke(255);
        sketch.line(borderMargin/2, borderMargin/2, sketch.width - borderMargin/2, borderMargin/2); //top line
        sketch.line(borderMargin/2, sketch.height - borderMargin/2, sketch.width - borderMargin/2, sketch.height - borderMargin/2); //bottom line
    }

    public float getBorderMargin() {
        return borderMargin;
    }

}
