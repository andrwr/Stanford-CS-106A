/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL = 0;
	
	public void run() {
		/* You fill this in */
		
		println("This program finds the largest and smallest number.");
		
		int number = readInt("? ");
		int smallest = number;
		int largest = number;
		while (number != SENTINEL) {
			number = readInt("? ");
			if (number < smallest) {
				smallest = number;
			}
			if (number > largest) {
				largest = number;
			}
		}
		println("smallest: " + smallest);
		println("largest: " + largest);
	}
}

