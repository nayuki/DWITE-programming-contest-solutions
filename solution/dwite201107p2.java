/* 
 * DWITE - July 2011 - Problem 2: Sum of primes
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


public final class dwite201107p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201107p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		int sum = 0;
		
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 0; i < isPrime.length; i++) {  // Sieve of Eratosthenes
			if (isPrime[i]) {
				for (int j = i * i; j < isPrime.length; j += i)
					isPrime[j] = false;
				sum += i;
			}
		}
		
		io.println(sum);
	}
	
}
