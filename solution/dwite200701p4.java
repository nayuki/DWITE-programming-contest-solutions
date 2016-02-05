/* 
 * DWITE - January 2007 - Problem 4: Number Theory
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200701p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200701p4().run("DATA41.txt", "OUT41.txt");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int n = io.readIntToken();
		int r = io.readIntToken();
		io.println(partition(n, r));
	}
	
	
	// Returns the number of ways n can be written as an unordered sum of k positive integers.
	private static int partition(int n, int k) {
		if (k > n)
			return 0;
		else if (k == n)
			return 1;
		else if (k == 0)
			return 0;
		else
			return partition(n - 1, k - 1) + partition(n - k, k);
	}
	
}
