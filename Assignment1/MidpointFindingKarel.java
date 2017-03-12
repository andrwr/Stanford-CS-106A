/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	// You fill in this part
	
	public void run() {
		firstProblemSolved();
		secondProblemSolved();
	}
	
	//pre-condition: left side with nothing 
	//post-condition: put everything and find the middle
	
	private void firstProblemSolved() {
		putBeeper();
		while(frontIsClear()) {
			move();
		}
		turnAround();
		while (noBeepersPresent()) {
			fillBeepers();
		}
	}
	
	private void fillBeepers() {
		putBeeper();
		move();
		if (noBeepersPresent()) {
			putBeeper();
			move();
			}
		stopMoving();
		turnA();
	}
	
	private void stopMoving() {
		while (noBeepersPresent()) {
			move();
		}
	}
	
	private void turnA() {
		if (beepersPresent()) {
			turnAround();
			move();
		}
	}
	
	private void secondProblemSolved() {
		while (frontIsClear()) {
			move();
			pickBeeper();
		}
		turnAround();
		stopMoving();
		while (frontIsClear()) {
			move();
			pickBeeper();
		}
		turnAround();
		stopMoving();
	}
}