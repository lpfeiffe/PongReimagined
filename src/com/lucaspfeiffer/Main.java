package com.lucaspfeiffer;

import processing.core.PApplet;

public class Main extends PApplet {

    private final static Main sketch = new Main();
    private Ball pongBall;
    private final static UI ui = new UI(sketch);

    //Used to initialize one-time settings for the sketch
    public void settings() {
        size(1000,600); //window size
        pongBall = new Ball(sketch, 20);
    }

    //This method is called 60 times per second (for 60 FPS)
    public void draw() {
        background(0); //black bg
        ui.showStartScreen();
        pongBall.move();
        pongBall.render();
    }

    public static void main(String[] args) {
        //Set up the processing interface with a new sketch
	    String[] processingArgs = new String[] { "Pong Reimagined" };
	    PApplet.runSketch(processingArgs, sketch);
    }
}
