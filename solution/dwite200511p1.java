/* 
 * DWITE programming contest solutions
 * November 2005 - Problem 1: "Quadrilateral Centroid"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200511p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200511p1().run("DATA11.txt", "OUT11.txt");
	}
	
	
	protected void runOnce() {
		// Read input and take the arithmetic mean
		double x = 0;
		double y = 0;
		for (int i = 0; i < 4; i++) {
			io.tokenizeLine();
			x += io.readDoubleToken();
			y += io.readDoubleToken();
		}
		x /= 4;
		y /= 4;
		
		// Round and write output
		x = Math.round(x * 100) / 100.0;
		y = Math.round(y * 100) / 100.0;
		io.printf("%.2f %.2f%n", x, y);
	}
	
}
