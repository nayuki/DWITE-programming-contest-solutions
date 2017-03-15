/* 
 * DWITE programming contest solutions
 * January 2012 - Problem 2: "Prime Time"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201201p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201201p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		boolean head = true;
		for (int i = 2; i <= n; i++) {
			if (!isPrime(i))
				continue;
			if (head) head = false;
			else io.print(" * ");
			io.print(i + "^" + countFactors(n, i));
		}
		io.println();
	}
	
	
	// Returns the number of times that the prime factor p occurs in n!.
	private static int countFactors(int n, int p) {
		int result = 0;
		for (; n >= p; n /= p)
			result += n / p;
		return result;
	}
	
	
	private static boolean isPrime(int n) {
		for (int i = 2, end = DwiteAlgorithm.sqrt(n); i <= end; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
}
