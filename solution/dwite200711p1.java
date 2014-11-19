/* 
 * DWITE - November 2007 - Problem 1: Not Quite Prime
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200711p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200711p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		
		/* 
		 * A number is semiprime iff it has 3 or 4 factors.
		 * In particular, it has 3 factors if it's the square of a prime;
		 * otherwise it has 4 factors if it's the product of two distinct primes.
		 */
		int factors = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				factors++;
		}
		if (factors == 3 || factors == 4)
			io.println("semiprime");
		else
			io.println("not");
	}
	
}
