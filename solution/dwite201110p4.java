/* 
 * DWITE - October 2011 - Problem 4: C001 Numbers
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201110p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201110p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	protected void runOnce() {
		io.println(getCoolness(io.readIntLine()));
	}
	
	
	/* 
	 * Computes the total coolness for [0, n] in essentially constant time.
	 * 
	 * Suppose we are given a value of n. For the following analysis, exclude 0 from the considered set of numbers and add it back at the end.
	 * 
	 * How many times is the ones digit equal to 0?
	 * If n < 10, then this happens zero times. Otherwise, it happens at multiples of 10 (i.e. 10, 20, 30, etc.), so it happens floor(n / 10) times.
	 * 
	 * How many times is the tens digit equal to 0?
	 * If n < 100, then this happens zero times. Otherwise, it happens in the first 10 numbers starting at each multiple of 100
	 * (i.e. 100, 101, ..., 109; 200, 201, ..., 209; etc.). So it happens floor((n + 1) / 100 - 1) * 10 + min(mod(n + 1, 100), 10) times.
	 * (The first term is for full blocks of 10, and the second term is for the last partial block of 0 to 10 occurrences.)
	 * 
	 * In general, for the digit representing 10^k, if n < 10^k then this digit is never equal to 0.
	 * Otherwise it is equal to 0 this many times: floor((n + 1) / 10^(k+1) - 1) * 10^k + min(mod(n + 1, 10^(k+1)), 10^k).
	 */
	private static int getCoolness(int n) {
		int sum = 1;
		int tenpow = 1;
		for (int i = 0; i <= 8; i++, tenpow *= 10) {
			if (n >= tenpow * 10)
				sum += ((n + 1) / (tenpow * 10) - 1) * tenpow + Math.min((n + 1) % (tenpow * 10), tenpow);
		}
		return sum;
	}
	
	
	/* 
	Naive algorithm for computing the coolness for 0 through n (inclusive):
		private static int getCoolness(int n) {
			int count = 0;
			for (int i = 0; i <= n; i++) {
				int temp = i;
				do {
					if (temp % 10 == 0)
						count++;
					temp /= 10;
				} while (temp != 0);
			}
			return count;
		}
	 */
	
}
