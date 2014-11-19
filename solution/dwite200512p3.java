/* 
 * DWITE - December 2005 - Problem 3: Reducing Fractions
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200512p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200512p3().run("DATA31.txt", "OUT31.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		io.tokenizeLine();
		int n = io.readIntToken();
		int d = io.readIntToken();
		
		if (d == 0)
			throw new AssertionError("Zero denominator");
		
		// Make only the numerator be possibly negative
		if (d < 0) {
			d = -d;
			n = -n;
		}
		
		// Write the negative sign if applicable, and handle positive fractions from now on
		if (n < 0) {
			io.print("-");
			n = -n;
		}
		
		// Reduce to lowest terms
		int gcd = DwiteAlgorithm.gcd(n, d);
		n /= gcd;
		d /= gcd;
		
		// Write output in the appropriate format
		if (d == 1)     io.printf("%d%n", n);                      // Integer
		else if (n < d) io.printf("%d/%d%n", n, d);                // Simple fraction
		else            io.printf("%d %d/%d%n", n / d, n % d, d);  // Mixed fraction
	}
	
}
