/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		remove(wordLabel);
		//add(wordLabel);
	}
	

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
		wordLabel = new GLabel(word);
		wordLabel.setFont("Helvetica-24");
		add(wordLabel, getWidth() / 2 - 100, getHeight() / 2 + getHeight() / 4);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
		if (letter != '0') {
			incorectLetters += letter;
			badLetter = new GLabel(incorectLetters);
			add(badLetter, wordLabel.getX(), wordLabel.getY() + 50);
		}

		double midX = getWidth() / 2;
		double midY = getHeight() / 2;
		
		GLine rope = new GLine(midX, midY - (ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH) / 4 - 150,
				midX, midY - (ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH) / 4 + ROPE_LENGTH - 150);
		GLine beam = new GLine(midX, rope.getY(), midX - BEAM_LENGTH, rope.getY());
		GLine scaffold = new GLine(midX - BEAM_LENGTH, rope.getY(), midX - BEAM_LENGTH, rope.getY() + SCAFFOLD_HEIGHT);

		
		
		GOval head = new GOval(midX - HEAD_RADIUS, rope.getY() + rope.getHeight(), 2 * HEAD_RADIUS, 2 * HEAD_RADIUS);
		
		GLine body = new GLine(midX, head.getY() + head.getHeight() + BODY_LENGTH, midX, head.getY() + head.getHeight());
		
		
		GLine leftHand = new GLine (midX, head.getY() + head.getHeight() + ARM_OFFSET_FROM_HEAD,
				midX - UPPER_ARM_LENGTH, head.getY() + head.getHeight() + ARM_OFFSET_FROM_HEAD);
		GLine leftHandContinued = new GLine(midX - UPPER_ARM_LENGTH, leftHand.getY(), midX - UPPER_ARM_LENGTH, leftHand.getY() + LOWER_ARM_LENGTH);
		GLine rightHand = new GLine(midX, leftHand.getY(), midX + UPPER_ARM_LENGTH, leftHand.getY());
		GLine rightHandContinued = new GLine (midX + UPPER_ARM_LENGTH, rightHand.getY(), midX + UPPER_ARM_LENGTH, rightHand.getY() + LOWER_ARM_LENGTH);
		GLine leftLeg = new GLine(midX - HIP_WIDTH, body.getY(), midX, body.getY());
		GLine leftLegContinued = new GLine(leftLeg.getX(), leftLeg.getY() + LEG_LENGTH, leftLeg.getX(), leftLeg.getY());
		GLine leftFoot = new GLine(leftLegContinued.getX(), leftLegContinued.getY(), leftLegContinued.getX() - FOOT_LENGTH, leftLegContinued.getY());
		
		GLine rightLeg = new GLine(midX + HIP_WIDTH, body.getY(), midX, body.getY());
		GLine rightLegContinued = new GLine(rightLeg.getX(), rightLeg.getY() + LEG_LENGTH, rightLeg.getX(), rightLeg.getY());
		GLine rightFoot = new GLine(rightLegContinued.getX(), rightLegContinued.getY(), rightLegContinued.getX() + FOOT_LENGTH, rightLegContinued.getY());
		
		int i = incorectLetters.length();
		if (i == 0) {
			add(scaffold);
			add(beam);
			add(rope);	
		}
		if (i == 1)		add(head);
		if (i == 2)		add(body);
		if (i == 3) {
			add(leftHand);
			add(leftHandContinued);
		}
		if (i == 4) {
			add(rightHand);
			add(rightHandContinued);
		}
		if (i == 5) {
			add(leftLeg);
			add(leftLegContinued);
		}
		if (i == 6) {
			add(rightLeg);
			add(rightLegContinued);
		}
		if (i == 7)		add(leftFoot);
		if (i == 8)		add(rightFoot);
		
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360/2;
	private static final int BEAM_LENGTH = 144/2;
	private static final int ROPE_LENGTH = 18/2;
	private static final int HEAD_RADIUS = 36/2;
	private static final int BODY_LENGTH = 144/2;
	private static final int ARM_OFFSET_FROM_HEAD = 28/2;
	private static final int UPPER_ARM_LENGTH = 72/2;
	private static final int LOWER_ARM_LENGTH = 44/2;
	private static final int HIP_WIDTH = 36/2;
	private static final int LEG_LENGTH = 108/2;
	private static final int FOOT_LENGTH = 28/2;
	
	private String incorectLetters = "";
	//private String word = "";
	
	private GLabel wordLabel;
	private GLabel badLetter;
	
	
}
