// DWITE - January 2007 - Problem 1: Filling The Cone

import dwite.*;


public final class dwite200701p1 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA11.txt", "OUT11.txt", new dwite200701p1());
	}
	
	
	protected void runOnce(Io io) {
		// Read input
		double coneheight = io.readDoubleLine();
		double coneradius = io.readDoubleLine();
		double watervolume = io.readDoubleLine();
		
		// Compute and write output
		double waterheight = Math.cbrt(watervolume / (Math.PI * coneradius * coneradius * coneheight / 3)) * coneheight;
		io.printf("%.2f%n", waterheight);
	}
	
}
