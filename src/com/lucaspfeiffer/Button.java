package com.lucaspfeiffer;

import processing.core.PApplet;

public class Button {

    private PApplet sketch;
    private float color;
    private float xPos;
    private float yPos;
    private String text;

    private float height;
    private float width;
    private float roundness;

    public Button(
            PApplet sketch,
            float color,
            String text,
            float height,
            float width,
            float roundness
    ) {
        this.sketch = sketch;
        this.color = color;
        this.text = text;
        this.height = height;
        this.width = width;
        this.roundness = roundness;
    }

    public void render(float xPos, float yPos) {
        this.xPos = xPos;
        this.yPos = yPos;

        sketch.stroke(color);
        sketch.strokeWeight(3);
        sketch.noFill();
        sketch.rectMode(sketch.CENTER);
        sketch.rect(xPos, yPos, width, height, roundness);

        sketch.textSize(30);
        sketch.textAlign(sketch.CENTER, sketch.CENTER);
        sketch.text(text, xPos, yPos - 5);

    }

    public float getHeight() {
        return height;
    }

    public float getxPos() {
        return xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public float getWidth() {
        return width;
    }
}
