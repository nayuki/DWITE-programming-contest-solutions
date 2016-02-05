/* 
 * DWITE - December 2010 - Problem 2: Unit rectangles
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201012p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201012p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		int count = 0;
		for (int i = 1; i <= n; i++)
			count += countSmallFactors(i);
		io.println(count);
	}
	
	
	// Counts the number of factors <= sqrt(n) by trial division
	private static int countSmallFactors(int n) {
		int count = 0;
		for (int i = 1, end = DwiteAlgorithm.sqrt(n); i <= end; i++) {
			if (n % i == 0)
				count++;
		}
		return count;
	}
	
}
