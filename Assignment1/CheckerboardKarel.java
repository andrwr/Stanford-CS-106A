/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// You fill in this part

/*	public void run() {
 *		while (frontIsClear()) {
 *				putOnColumn1();
 *		}
 *	}  *	
 *	private void putOnColumn1() {
 *		int count = 0;
 *		turnLeft();
 *		putBeeper();
 *		while (frontIsClear()) {
 *			if (noBeepersPresent()) {
 *				putBeeper();
 *			}
 *			move();
 *			count++;
 *			if (frontIsClear()) {
 *				move();
 *				count++;
 *			}
 *		}
 *		if (count % 2 == 0 && noBeepersPresent()) {
 *			putBeeper();
 *		}
 *		turnRight();
 *		if (frontIsClear()) {
 *			move();
 *		}
 *		turnRight();
 *		while (frontIsClear()) {
 *			if (count % 2 == 0) {
 *				move();
 *				count++;
 *			}
 *			putBeeper();
 *			if (frontIsClear()) {
 *				move();
 *			}
 *			if (frontIsClear()) {
 *				move();
 *			}
 *		}
 *		turnLeft();
 *		if (frontIsClear()) {
 *			move();
 *		}
 *	}	
 *
 */
	public void run(){
		putBeeper();
		completeEastLine();
	}
	
	/*
	 *METHOD: completeEastLine()
	 *
	 *pre-condition:
	 *Karel is facing East at the left-most square of a new line.
	 *
	 *post-condition
	 *Karel is either facing West on the next line
	 *up or program is finished.
	 *
	 *
	 *Note: completeEastLine and completeWestLine make use of
	 *mutual recursion to have Karel alternate rows to complete
	 *the checkerboard.
	 */

	private void completeEastLine(){
		alternateToWall();
		turnLeft();
		if (frontIsClear()){
			startNextLine();
			turnLeft();
			completeWestLine();
		}
	}

	/*METHOD: completeWeestLine()
	 * 
	 *pre-condition: 
	 *Karel is facing West on a new line.
	 *
	 *post-condition: 
	 *Karel is either facing East on the next line up or program 
	 *is finished.
	 */
	
	private void completeWestLine(){
		alternateToWall();
		turnRight();
		if (frontIsClear()){
			startNextLine();
			turnRight();
			completeEastLine();
		}
	}
	
	/*METHOD: startNextLine()
	 * 
	 *pre-condition: 
	 *Karel is at the end of a line facing the next row up and he may or may
	 *not be presently on a beeper.
	 *
	 *post-condition: 
	 *Karel has now moved to the next row up and is still facing 
	 *up. Karel has also placed a beeper on his current square
	 *if he wasn't on one before and hasn't placed one if he was
	 *on one before.
	 */
	
	private void startNextLine(){
		if (beepersPresent()){
			move();	
		}
		else {
			move();
			putBeeper();
		}
	}
	
	/*METHOD: alternateToWall()
	 *pre-condition: 
	 *Karel is either facing East or West at the beginning of a 
	 *new line.
	 *
	 *post-condition: 
	 *Karel has now traversed the line and has in doing so has
	 *placed beepers on every other square.
	 */
	
	private void alternateToWall(){
		while (frontIsClear()){
			if (beepersPresent()){
				move();
			}
			else {
				move();
				putBeeper();
			}
		}
	}

}