/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	private static final int BOX_WIDTH = 120;
	
	private static final int BOX_HEIGHT = 40;
	
	 private static final int howMany = 3;
	
	public void run() {
		/* You fill this in. */
		
		int xMid = getWidth() / 2;
		int yMid = getHeight() / 2;
		int firstX = xMid - BOX_WIDTH / 2;
		int firstY = yMid - BOX_HEIGHT / 2 - 2 * BOX_HEIGHT;
		
		GRect box = new GRect(firstX, firstY, BOX_WIDTH, BOX_HEIGHT);
		add(box); 
		GLabel label1 = new GLabel("Program");
		label1.setLocation(firstX + BOX_WIDTH / 2 - label1.getWidth() / 2, firstY + BOX_HEIGHT / 2 + label1.getHeight() / 2);
		add(label1);
		
		for (int i = 1; i <= howMany; i++) {
			int distance = (howMany - i - 1) * (BOX_WIDTH / 5);
			int xDown = (firstX + ((i - howMany + 1) * BOX_WIDTH))  - distance;
			int yDown = firstY + 2 * BOX_HEIGHT;
			// Boxes ready
			
			GRect downBox = new GRect(xDown, yDown, BOX_WIDTH, BOX_HEIGHT);
			add(downBox);
			
			// Lines ready
			
			GLine line = new GLine(firstX + BOX_WIDTH / 2, firstY + BOX_HEIGHT, xDown + BOX_WIDTH / 2, yDown);
			add(line);
			
			// Labels ready
			
			GLabel labelDown = new GLabel("GraphicsProgram");
			if (i == 1) {
				labelDown.setLabel("GraphicsProgram");
				labelDown.setLocation(xDown + BOX_WIDTH / 2 - labelDown.getWidth() / 2, yDown + BOX_HEIGHT / 2 + labelDown.getHeight() / 2);
			} else if(i == 2){
				labelDown.setLabel("ConsoleProgram");
				labelDown.setLocation(xDown + BOX_WIDTH / 2 - labelDown.getWidth() / 2, yDown + BOX_HEIGHT / 2 + labelDown.getHeight() / 2);
			} else {
				labelDown.setLabel("DialogProgram");
				labelDown.setLocation(xDown + BOX_WIDTH / 2 - labelDown.getWidth() / 2, yDown + BOX_HEIGHT / 2 + labelDown.getHeight() / 2);
			}
			add(labelDown);
		}
	}
}

