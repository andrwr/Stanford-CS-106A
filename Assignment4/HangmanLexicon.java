/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;

import java.io.*;
import java.util.*;


public class HangmanLexicon{

	private BufferedReader openFile(String prompt) {
		BufferedReader rd = null;
		while (rd == null) {
			try {
				rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			} catch (IOException ex) {
				
			}
		}
		return rd;
	}
	
	public HangmanLexicon() {
		BufferedReader rd = openFile("Open");
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				a.add(line);
			}
			rd.close();
			
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
/** Returns the number of words in the lexicon. */
	
	public int getWordCount() {
		return a.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return (String) a.get(index - 1);
	}
	
	ArrayList a = new ArrayList();
	
}
