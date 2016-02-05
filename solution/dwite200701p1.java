/* 
 * DWITE - January 2007 - Problem 1: Filling The Cone
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200701p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200701p1().run("DATA11.txt", "OUT11.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		double coneHeight  = io.readDoubleLine();
		double coneRadius  = io.readDoubleLine();
		double watervolume = io.readDoubleLine();
		
		// Compute and write output
		double waterHeight = Math.cbrt(watervolume / (Math.PI * coneRadius * coneRadius * coneHeight / 3)) * coneHeight;
		io.printf("%.2f%n", waterHeight);
	}
	
}
