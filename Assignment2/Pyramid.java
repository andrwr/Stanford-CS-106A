/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	// I don't know how i did this! But i love it.
	/*public void run() {
		 You fill this in. 
		
		double xStart = (getWidth() / 2) - (BRICKS_IN_BASE / 2 * BRICK_WIDTH);
		int yStart = getHeight() - BRICK_HEIGHT;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < BRICKS_IN_BASE - i; j++) {
				double xHalf = j * (BRICK_WIDTH / 2);
				GRect drept = new GRect(xStart + i * BRICK_WIDTH + xHalf, yStart - j * BRICK_HEIGHT,
						BRICK_WIDTH, BRICK_HEIGHT);
				add(drept);
			}
		}
		
	}
	*/
	public void run() {
		/* You fill this in. */
		
		double xStart = (getWidth() / 2) - (BRICKS_IN_BASE / 2 * BRICK_WIDTH);
		int yStart = getHeight() - BRICK_HEIGHT;
		
		for (int i = 0; i < BRICKS_IN_BASE; i++) {
			for (int j = 0; j < BRICKS_IN_BASE - i; j++) {
				double xHalf = i * (BRICK_WIDTH / 2);
				GRect drept = new GRect(xStart + j * BRICK_WIDTH + xHalf, yStart - i * BRICK_HEIGHT,
						BRICK_WIDTH, BRICK_HEIGHT);
				add(drept);
			}
		}
		
	}
}

