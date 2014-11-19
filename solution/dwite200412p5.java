/* 
 * DWITE - December 2004 - Problem 5: Hidden Geography
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200412p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200412p5().run("DATA51.txt", "OUT51.txt");
	}
	
	
	private static final String[] PROVINCES = {
		"British Columbia", "Alberta", "Saskatchewan", "Manitoba", "Ontario",
		"Quebec", "Nova Scotia", "Newfoundland", "New Brunswick", "Prince Edward Island"
	};
	
	
	protected void runOnce() {
		// Read input
		String line = normalize(io.readLine());
		
		// Find province at lowest index
		int minIndex = -1;
		String minProvince = null;
		for (String prov : PROVINCES) {
			int index = line.indexOf(normalize(prov));
			if (index != -1 && (minIndex == -1 || index < minIndex)) {
				minIndex = index;
				minProvince = prov;
			}
		}
		
		// Write output
		if (minIndex != -1)
			io.println(minProvince);
		else
			io.println("NO PROVINCE FOUND");
	}
	
	
	// Converts to lowercase and strips all non-letters
	private static String normalize(String s) {
		return s.toLowerCase().replaceAll("[^a-z]", "");
	}
	
}
