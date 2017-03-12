/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class Target extends GraphicsProgram {	
	
	private static final int OUTER_CIRC = 72;
	
	private static final int MID_CIRC = (int)(0.65 * 72);
	
	private static final int INNER_CIRC = (int)(0.3 * 72);
	
	public void run() {
		/* You fill this in. */
		
		int difference = OUTER_CIRC - MID_CIRC;
		int Xmiddle = getWidth() / 2;
		int Ymiddle = getHeight() / 2;
		
		GOval outer = new GOval(Xmiddle - OUTER_CIRC / 2, Ymiddle - OUTER_CIRC / 2, OUTER_CIRC, OUTER_CIRC);
		outer.setColor(Color.RED);
		outer.setFilled(true);
		outer.setFillColor(Color.RED);
		
		GOval mid = new GOval(Xmiddle - MID_CIRC / 2, Ymiddle - MID_CIRC / 2, MID_CIRC, MID_CIRC);
		mid.setColor(Color.WHITE);
		mid.setFilled(true);
		mid.setFillColor(Color.WHITE);
		
		GOval inner = new GOval(Xmiddle - INNER_CIRC / 2, Ymiddle - INNER_CIRC / 2, INNER_CIRC, INNER_CIRC);
		inner.setColor(outer.getColor());
		inner.setFilled(true);
		inner.setFillColor(outer.getColor());
		
		add(outer);
		add(mid);
		add(inner);
		
	}
}
