// DWITE - January 2006 - Problem 1: Filling The Cone

import dwite.*;


public final class dwite200601p1 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA11.txt", "OUT11.txt", new dwite200601p1());
	}
	
	
	protected void runOnce() {
		// Read input
		double h = io.readDoubleLine();
		double r = io.readDoubleLine();
		double v = io.readDoubleLine();
		
		// Compute and write output
		double x = Math.pow(3 * v * h * h / (3.1415926 * r * r), 1 / 3D);  // Height of water
		io.printf("%.2f%n", x);
	}
	
}
