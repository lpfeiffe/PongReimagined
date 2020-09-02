package com.lucaspfeiffer;

import processing.core.PApplet;

public class Main extends PApplet {

    //Used to initialize one-time settings for the sketch
    public void settings() {

    }

    //This method is called 60 times per second (for 60 FPS)
    public void draw() {

    }

    public static void main(String[] args) {
        //Set up the processing interface with a new sketch
	    String[] processingArgs = new String[] { "Pong Reimagined" };
	    Main sketch = new Main();
	    PApplet.runSketch(processingArgs, sketch);
    }
}
