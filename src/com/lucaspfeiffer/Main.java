package com.lucaspfeiffer;

import processing.core.PApplet;

public class Main extends PApplet {

    enum Stage {
        START,
        LEVEL1,
        END
    }

    private final static Main sketch = new Main();
    private final static UI ui = new UI(sketch);
    private Ball pongBall;
    private Stage stage;
    private Bumper leftBumper;
    private Bumper rightBumper;
    private boolean leftUP;
    private boolean leftDOWN;
    private boolean rightUP;
    private boolean rightDOWN;


    //Used to initialize one-time settings for the sketch
    public void settings() {
        smooth();
        size(1000,600); //window size
        pongBall = new Ball(sketch, ui,20);
        leftBumper = new Bumper(sketch, ui, "left");
        rightBumper = new Bumper(sketch, ui, "right");
        stage = Stage.START;
    }

    //This method is called 60 times per second (for 60 FPS)
    public void draw() {
        background(0); //black bg
        //select which stage of the game to show
        if (stage == Stage.START) {
            ui.displayStartScreen();
        }
        else if (stage == Stage.LEVEL1) {
            ui.displayLevel1();
        }
        else {

        }
        //render ball
        if (stage != Stage.START && stage != Stage.END) {
            performMove();
            pongBall.move();
            pongBall.render();

        }
        leftBumper.render();
        rightBumper.render();

    }

    public void mouseClicked() {
        if (stage == Stage.START)
            stage = Stage.LEVEL1;
        pongBall.firstMove = true;
    }

    public void keyPressed() {
        if (stage != Stage.START && stage != Stage.END) {
            if (key == CODED)
                userMove(keyCode, true);
            else
                userMove(key, true);
        }
    }

    public void keyReleased() {
        if (stage != Stage.START && stage != Stage.END) {
            if (key == CODED)
                userMove(keyCode, false);
            else
                userMove(key, false);
        }
    }

    public void userMove(int key, boolean pressed) {
            if (keyCode == UP) //player 2 moved their paddle
                rightUP = pressed;
            if (keyCode == DOWN)
                rightDOWN = pressed;
    }

    public void userMove(char key, boolean pressed) {
        if (key == 'w' || key == 'W') //player 1 moved their paddle
            leftUP = pressed;
        else if (key == 's' || key == 'S')
            leftDOWN = pressed;
    }

    public void performMove() {
        if (rightUP)
            rightBumper.move(0);
        if (rightDOWN)
            rightBumper.move(1);
        if (leftUP)
            leftBumper.move(0);
        if (leftDOWN)
            leftBumper.move(1);
    }

    public static void main(String[] args) {
        //Set up the processing interface with a new sketch
	    String[] processingArgs = new String[] { "Pong Reimagined" };
	    PApplet.runSketch(processingArgs, sketch);
    }
}
