// DWITE - December 2004 - Problem 1: Prime Factorization

import dwite.*;


public final class dwite200412p1 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA11.txt", "OUT11.txt", new dwite200412p1());
	}
	
	
	protected void runOnce(Io io) {
		io.println(factor(io.readIntLine()));
	}
	
	
	private static String factor(int x) {
		for (int i = 2, end = sqrt(x); i <= end; i++) {
			if (x % i == 0)
				return String.format("%d*%s", i, factor(x / i));  // x is composite
		}
		return Integer.toString(x);  // x is prime
	}
	
	
	
	private static int sqrt(int x) {
		int y = 0;
		for (int i = 15; i >= 0; i--) {
			y |= 1 << i;
			if (y > 46340 || y * y > x)
				y ^= 1 << i;
		}
		return y;
	}
	
}