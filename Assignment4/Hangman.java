/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}
	
    public void run() {
		/* You fill this in */
    	
    	println("number in shorter: " + lexi.getWordCount());
    	println("word: " + lexi.getWord(lexi.getWordCount()));
    	
    	println("Welcome to Hangman!");
    	canvas.noteIncorrectGuess('0');
    	while (gameOn()) {
    		canvas.displayWord(hidden);
//    		println(word);
        	println("The word now looks like this: " + hidden);
        	println("You have " + (8 - times) + " guesses.");
    		String guessed = readLine("Your guess: ");
    		if (guessed.length() != 0) {
    			char g = guessed.charAt(0);
    			if (!Character.isLetter(g)) {
            		println("WTF dude? is " + g + " a letter?");
            		canvas.reset();
            		continue;
            	} else if (guessed.length() > 1) {
            		canvas.reset();
            		println("Only one character. Try again.");
            		continue;
        		}    			
        		checkGuessed(g);
    		} else {
    			println("Wow, what a nice letter!");
    			canvas.reset();
    			continue;
    		}
    		checkIfOver();
    		canvas.reset();
    	}
    	canvas.displayWord(hidden);
    }
    
    public void checkIfOver() {
    	
    	if (!hidden.contains("-")) {
    		win = true;
    		lost = true;
    		println("You win!");
    	}
    	if (times == 8) {
    		lost = true;
    		win = true;
    		println("You're completely hung!");
    		println("The word was: " + word);
    		println("You lose.");
    	}
    }
    
    public Boolean gameOn() {
    	return !win || !lost;
    }
    
    public char upperLetter(char guessed) {
    	if (guessed > 'a' || guessed < 'z') {
			guessed = Character.toUpperCase(guessed);
		}
    	return guessed;
    }
    
    public void checkGuessed(char guessed) {
    	int i = 0;
    	guessed = upperLetter(guessed);
    	boolean incorect = true;
    	while (i < word.length()) {
    		if (guessed == hidden.charAt(i)) {
    			incorect = false;
    		} else if (guessed == word.charAt(i)) {
    			updateHidden(i, guessed);
    			incorect = false;
    		}
    		i++;
    	}
  
    	if (incorect) {
    		checkIfBad(guessed);
    	}
    }
    
    public void checkIfBad(char guessed) {
    	int j = 0;
		boolean alreadyThere = false;
		while (j < badGuess.length()) {
			if (guessed == badGuess.charAt(j)) {
				alreadyThere = true;
			}
			j++;
		}
		if (!alreadyThere) {
			badGuess += guessed;
			canvas.noteIncorrectGuess(guessed);
			times++;
			if (times != 8)		println("There are no " + guessed + "'s in the word.");
		}
    }
    
    /** Offers first hidden word */
    public String hiddenWord(String word) {
    	int i = 0;
    	String result = "";
    	while (i < word.length()) {
    		result += "-";
    		i++;
    	}
    	return result;
    }
    
    /** Updates hiddenWord */
    public void updateHidden(int index, char ch) {
    	
    	String result = "";
    	result = hidden.substring(0, index) + ch + hidden.substring(index + 1, hidden.length());
    	hidden = result;	
    }
    
    private HangmanCanvas canvas;
    
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private Boolean win = false;
    private Boolean lost= false;
    HangmanLexicon lexi = new HangmanLexicon();
	String word = lexi.getWord(rgen.nextInt(lexi.getWordCount() - 1));
	String hidden = hiddenWord(word);
	String badGuess = "";
	private int times = 0;

}
