/* 
 * DWITE - January 2005 - Problem 3: Harshad Numbers
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200501p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200501p3().run("DATA31.txt", "OUT31.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		int start = io.readIntLine();
		int end   = io.readIntLine();
		
		// Compute longest run
		int longestRun = 0;
		int currentRun = 0;
		for (int i = start; i <= end; i++) {
			if (i % getDigitSum(i) == 0) {
				currentRun++;
				longestRun = Math.max(currentRun, longestRun);
			} else
				currentRun = 0;
		}
		
		// Write output
		io.println(longestRun);
	}
	
	
	private static int getDigitSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
	
}
