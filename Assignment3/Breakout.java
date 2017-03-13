/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		setup();
		
		
		while (GAME_ON()) {
			moveBall(vx, vy);
			pause(PAUSE_TIME);
			checkWall();
			checkCollisions();
		}
		remove(ball);
		remove(lives);
		
		GLabel finalLabel = new GLabel("");
		if (numberOfLives()) {
			finalLabel.setLabel("YOU WIN");
		} else {
			finalLabel.setLabel("YOU LOSE");
		}
		
		finalLabel.setLocation(WIDTH / 2 - finalLabel.getWidth() / 2, HEIGHT / 2 - finalLabel.getHeight() / 2);
		add(finalLabel);
		
	}
	
	
	
	public void speedUp() {
		if (totalBricks == 90) {
			PAUSE_TIME -= 4;
		}
		if (totalBricks == 70) {
			PAUSE_TIME -= 2;
		}
		if (totalBricks == 50) {
			PAUSE_TIME -= 3;
		}
		if (totalBricks == 25) {
			PAUSE_TIME -= 4;
		}
	}
	
	public void showLives() {
		lives = new GLabel("Lives left: " + life, 30, 30);
		lives.setFont("Times-15");
		add(lives);
	}
	
	public void randomBall() {
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) vx = -vx;
		vy = 3.0;
	}
	
	public boolean GAME_ON() {
		if (!numberOfLives() || !allBricksDestroyed()) {
			return false;
		}
		return true;
	}
	
	public boolean numberOfLives() {
		if (life < 0) {
			return false;
		}
		return true;
	}
	
	public boolean allBricksDestroyed() {
		if (totalBricks < 0) {
			return false;
		}
		return true;
	}
	
	public void mouseMoved(MouseEvent e) {
		if (e.getX() > 0 + PADDLE_WIDTH / 2 && e.getX() < WIDTH - PADDLE_WIDTH / 2) {
			paddle.move(e.getX() - paddle.getX() - PADDLE_WIDTH / 2, 0);	
		}
	}
	
	/** The setup of the game including graphics */
	public void setup() {
		createBricks();
		createPaddle();
		createBall();
		randomBall();
		showLives();
		showScore();
		addMouseListeners();
	}
	
	/** Paddle */
	public void createPaddle() {
		paddle = new GRect((WIDTH - PADDLE_WIDTH) / 2, HEIGHT - PADDLE_Y_OFFSET,
				PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
	}
	
	/** Bricks */
	public void createBricks() {
		
		double xStart = (WIDTH - (NBRICKS_PER_ROW * BRICK_WIDTH + (BRICK_SEP * NBRICKS_PER_ROW - 1))) / 2 ;
		double yStart = BRICK_Y_OFFSET;
		for (int i = 0; i < NBRICK_ROWS; i++) {
			for (int j = 0; j < NBRICKS_PER_ROW; j++) {
				brick = new GRect(xStart + j * (BRICK_WIDTH + BRICK_SEP), yStart + i * (BRICK_HEIGHT + BRICK_SEP),
						BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				if (i == 0 || i == 1) {
					brick.setColor(Color.RED);
					brick.setFillColor(Color.RED);
				} else if (i == 2 || i == 3) {
					brick.setColor(Color.ORANGE);
					brick.setFillColor(Color.ORANGE);
				} else if (i == 4 || i == 5) {
					brick.setColor(Color.YELLOW);
					brick.setFillColor(Color.YELLOW);
				} else if (i == 6 || i == 7) {
					brick.setColor(Color.GREEN);
					brick.setFillColor(Color.GREEN);
				} else {
					brick.setColor(Color.CYAN);
					brick.setFillColor(Color.CYAN);
				}
				add(brick);
			}
		}
	}
	
	public void createBall() {
		ball = new GOval(WIDTH / 2 - BALL_RADIUS, HEIGHT / 2 - BALL_RADIUS, diam, diam);
		ball.setFilled(true);
		add(ball);
	}
	
	public void moveBall(double vx, double vy) {
		if (gameStarted) {
			ball.move(vx,vy);		
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		gameStarted = true;
	}
	
	public void checkWall() {
		if (ball.getX() < 0 || ball.getX() > WIDTH - diam) {
			vx = -vx;
		}
		if (ball.getY() < 0) {
			vy = -vy;
		}
		if (ball.getY() > HEIGHT - diam) {
			life -= 1;
			reset();
		}
	}
	
	private GObject getCollidingObject() {
		if (getElementAt(ball.getX(), ball.getY()) != null) {
			return getElementAt(ball.getX(), ball.getY());
		} else if (getElementAt(ball.getX() + diam, ball.getY()) != null) {
			return getElementAt(ball.getX() + diam, ball.getY());
		} else if (getElementAt(ball.getX() + diam, ball.getY() + diam) != null) {
			return getElementAt(ball.getX() + diam, ball.getY() + diam);
		} else if (getElementAt(ball.getX(), ball.getY() + diam) != null) {
			return getElementAt(ball.getX(), ball.getY() + diam);
		} else {
			return null;
		}
	}
	
	public void checkCollisions() {
		GObject collider = getCollidingObject();
		if (collider == paddle) {
			if (ball.getY() + diam - diam / 9 < paddle.getY()){
				//               ball comes from the left of the paddle
				// first quater
				if (ball.getX() + BALL_RADIUS < paddle.getX() + PADDLE_WIDTH / 8) {
					deviation(1);
					if (vx > 0) {
						vx = -vx;
					}
				} 
				// second
				else if ((ball.getX() + BALL_RADIUS > paddle.getX() + PADDLE_WIDTH / 8) &&
						(ball.getX() + BALL_RADIUS < paddle.getX() + PADDLE_WIDTH / 2 - PADDLE_WIDTH / 8)) {
					deviation(-1);
				} 
				//               ball comes from the right of the paddle
				// 3th
				else if ((ball.getX() + BALL_RADIUS > paddle.getX() + PADDLE_WIDTH / 2 + PADDLE_WIDTH / 8) &&
						(ball.getX() + BALL_RADIUS < paddle.getX() + PADDLE_WIDTH - PADDLE_WIDTH / 8)) {
					deviation(-1);
				} 
				// Last
				else if ((ball.getX() + BALL_RADIUS > paddle.getX() + PADDLE_WIDTH - PADDLE_WIDTH / 8)) {
					deviation(1);
					if (vx < 0) {
						vx = -vx;
					}
				} else 
					vy = -vy;
				
			} 
			
			// Ball is out, but in a correct form.
			else {
				if ((vx > 0 && ball.getX() + diam < paddle.getX() + 2) ||
						(vx < 0 && ball.getX() + diam > paddle.getX() + PADDLE_WIDTH)) {
					vx = -vx;
				}
			}
			bounceClip.play();
		} 
		
		// Anything else but the paddle
		else if (collider != null && collider != paddle && collider != lives && collider != scoreLabel){
			vy = -vy;
			checkColor(collider);
			remove(collider);
			totalBricks -= 1;
			remove(scoreLabel);
			showScore();
			speedUp();
			bounceClip.play();
		}
	}
	
	public void checkColor(GObject collider) {
		if (collider.getColor() == Color.CYAN) {
			SCORE +=1;
		} else if (collider.getColor() == Color.GREEN) {
			SCORE += 5;
		} else if (collider.getColor() == Color.YELLOW) {
			SCORE += 10;
		} else if (collider.getColor() == Color.ORANGE) {
			SCORE += 25;
		} else if (collider.getColor() == Color.RED) {
			SCORE += 50;
		}
	}
	
	public void deviation(double x) {
		if (vx < 0) {
			vx += -x;
		} else
			vx += +x;
		vy = -vy;
	}
	
	public void showScore() {
		scoreLabel = new GLabel("Points: " + SCORE, WIDTH / 2, 30);
		scoreLabel.setFont("Times-15");
		add(scoreLabel);
	}
	
	public void reset() {
		remove(ball);
		remove(lives);
		showLives();
		createBall();
		randomBall();
		gameStarted = false;
	}
	
	AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
	private int diam = 2 * BALL_RADIUS;
	private boolean gameStarted = false;
	private GRect brick;
	private GRect paddle;
	
	private GLabel lives;
	private GLabel scoreLabel;
	
	private GOval ball;
	private double vx, vy;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private int PAUSE_TIME = 28;
	private int life = 3;
	private int SCORE = 0;
	private int totalBricks = NBRICK_ROWS * NBRICKS_PER_ROW;
}
