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
    private final int maxScore = 10;
    private Ball pongBall;
    private Stage stage;
    private Bumper leftBumper;
    private Bumper rightBumper;
    private boolean[] bumperMoved = new boolean[4]; //0 = LU, 1 = LD, 2 = RU, 3 = RD

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
        } else if (stage == Stage.LEVEL1) {
            ui.displayLevel1(leftBumper.getScore(), rightBumper.getScore());
        } else if (stage == Stage.END) {
            if (leftBumper.getScore() >= maxScore) {
                ui.displayEnd("Player 1");
            } else if (rightBumper.getScore() >= maxScore) {
                ui.displayEnd("Player 2");
            }
        }

        if (stage != Stage.START && stage != Stage.END) {
            updateBumpers();
            pongBall.move(leftBumper, rightBumper);
            pongBall.render();
            if (pongBall.ballOut() != 0) {
                if (pongBall.ballOut() < 0) rightBumper.setScore(rightBumper.getScore() + 1);
                if (pongBall.ballOut() > 0) leftBumper.setScore((leftBumper.getScore() + 1));
                if (leftBumper.getScore() >= maxScore || rightBumper.getScore() >= maxScore)
                    stage = Stage.END;
                else
                    resetGameObjects(false);
            }
        }
        leftBumper.render();
        rightBumper.render();
    }

    public void mouseClicked() {
        if (stage == Stage.START) stage = Stage.LEVEL1;
        if (stage == Stage.END) {
            stage = Stage.START;
            resetGameObjects(true);
        }
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

    private void userMove(int key, boolean pressed) {
        if (keyCode == UP) bumperMoved[2] = pressed; //player 2 moved their paddle
        if (keyCode == DOWN) bumperMoved[3] = pressed;
    }

    private void userMove(char key, boolean pressed) {
        if ((key == 'w' || key == 'W')) bumperMoved[0] = pressed; //player 1 moved their paddle
        if ((key == 's' || key == 'S')) bumperMoved[1] = pressed;
    }

    private void updateBumpers() {
        if (bumperMoved[2]) rightBumper.move(0); //right up
        if (bumperMoved[3]) rightBumper.move(1); //right down
        if (bumperMoved[0]) leftBumper.move(0); //left up
        if (bumperMoved[1]) leftBumper.move(1); //left down
    }

    private void resetGameObjects(boolean newGame) {
        if (newGame) {
            leftBumper = new Bumper(sketch, ui, "left");
            rightBumper = new Bumper(sketch, ui, "right");
            bumperMoved = new boolean[4];
        }
        pongBall = new Ball(sketch, ui,20);
    }

    public static void main(String[] args) {
        //Set up the processing interface with a new sketch
	    String[] processingArgs = new String[] { "Pong Reimagined" };
	    PApplet.runSketch(processingArgs, sketch);
    }
}
