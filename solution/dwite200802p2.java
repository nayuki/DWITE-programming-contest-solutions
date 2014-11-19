/* 
 * DWITE - February 2008 - Problem 2: Number of factors
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200802p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200802p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		int factors = 0;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				factors++;
				n /= i;
				i--;
			}
		}
		if (factors == 1)
			factors = 0;
		io.println(factors);
	}
	
}
