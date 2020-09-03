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

    public void showStartScreen() {
        displayTitle("PONG REIMAGINED", sketch.width/2, sketch.height/3);
        displaySubTitle("\"Feature Creep\"... but on purpose!", sketch.width/2, sketch.height/3 + 50);
    }

    private void displayTitle(String string, float xPos, float yPos) {
        drawBorder();
        sketch.textSize(titleSize);
        sketch.textAlign(sketch.CENTER);
        sketch.text(string, xPos, yPos);
    }

    private void displaySubTitle(String string, float xPos, float yPos) {
        drawBorder();
        sketch.textSize(subTitleSize);
        sketch.textAlign(sketch.CENTER);
        sketch.text(string, xPos, yPos);
    }

    private void drawBorder() {
        sketch.strokeWeight(2);
        sketch.stroke(255);
        sketch.noFill();
        sketch.rect(
                borderMargin/2,
                borderMargin/2,
                sketch.width - borderMargin,
                sketch.height - borderMargin);
    }

    public float getBorderMargin() {
        return borderMargin;
    }

}
