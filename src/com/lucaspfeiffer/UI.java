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

    public void displayLevel1(int p1Score, int p2Score) {
        drawBorder();
        displayScore(p1Score, p2Score);
    }

    public void displayEnd(String winner) {
        drawBorder();
        displaySubTitle("GAME OVER " + winner.toUpperCase() + " WON!", (float)sketch.width/2, (float)sketch.height/2);
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

    private void displayScore(int p1Score, int p2Score) {
        sketch.noStroke();
        sketch.fill(255);
        sketch.rectMode(sketch.CENTER);
        sketch.rect(sketch.width/2, 75, 3, 80);
        if (p1Score < 10)
            displayTitle(Integer.toString(p1Score), sketch.width/2 - 35, 95); //player 1s score
        else
            displayTitle(Integer.toString(p1Score), sketch.width/2 - 45, 95); //player 1s score
        if (p2Score < 10)
            displayTitle(Integer.toString(p2Score), sketch.width/2 + 35, 95); //player 2s score
        else
            displayTitle(Integer.toString(p2Score), sketch.width/2 + 45, 95); //player 2s score
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
