/* 
 * DWITE programming contest solutions
 * February 2011 - Problem 1: "Colourful Words"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201102p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201102p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		// Read word and letter colors
		io.tokenizeLine();
		char[] word = io.readToken().toCharArray();
		String colours = io.readToken();
		if (word.length != colours.length())
			throw new IllegalArgumentException();
		
		// Read lights
		String light = io.readLine();
		for (String lightColour : light.split("\\+")) {
			if (lightColour.length() != 1)
				throw new IllegalArgumentException();
			
			// Eliminate letters of the current color
			for (int i = 0; i < word.length; i++) {
				if (colours.charAt(i) == lightColour.charAt(0))
					word[i] = '_';
			}
		}
		
		io.println(new String(word));
	}
	
}
