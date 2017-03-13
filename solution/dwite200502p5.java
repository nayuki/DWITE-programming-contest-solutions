/* 
 * DWITE programming contest solutions
 * February 2005 - Problem 5: "Tsunami Speed"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200502p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200502p5().run("DATA51.txt", "OUT51.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		int h = io.readIntLine();         // Water depth in metres
		int d = io.readIntLine() * 1000;  // Distance in metres
		
		// Compute and write output
		double c = Math.sqrt(9.8 * h);  // Wave speed in metres per second
		long time = Math.round(d / c);  // Travel time in seconds
		io.printf("%d hour(s) %d minute(s) %d second(s)%n", time / 3600, time / 60 % 60, time % 60);
	}
	
}
