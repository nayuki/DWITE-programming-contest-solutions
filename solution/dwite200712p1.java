/* 
 * DWITE - December 2007 - Problem 1: Yet Another Primes Question
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200712p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200712p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		int primeCount = 0;
		int lastPrime = 0;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				if (i == lastPrime) {  // Repeated prime
					io.println("not");
					return;
				}
				primeCount++;
				lastPrime = i;
				n /= i;
				i--;  // Retry this factor
			}
		}
		if (n != 1)
			throw new AssertionError();
		if (primeCount == 3)
			io.println("valid");
		else
			io.println("not");
	}
	
}
