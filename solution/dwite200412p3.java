/* 
 * DWITE programming contest solutions
 * December 2004 - Problem 3: "Reflections"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200412p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200412p3().run("DATA31.txt", "OUT31.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		double length     = io.readDoubleLine();  // Variable L
		double separation = io.readDoubleLine();  // Variable D
		double angle      = io.readDoubleLine();  // Variable x
		
		// Compute and write output
		double refldist = separation / Math.tan(Math.toRadians(angle));  // Horizontal distance between reflections
		io.println((int)(length / refldist + 0.5));
	}
	
}
