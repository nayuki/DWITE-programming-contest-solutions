/* 
 * DWITE - March 2010 - Problem 2: Round to Second Prime
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201003p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201003p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	private static boolean[] isPrime = DwiteAlgorithm.sievePrimes(150);
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		
		int low = n;
		do low--;
		while (!isPrime[low]);
		do low--;
		while (!isPrime[low]);
		
		int high = n;
		do high++;
		while (!isPrime[high]);
		do high++;
		while (!isPrime[high]);
		
		if (high - n <= n - low)
			io.println(high);
		else
			io.println(low);
	}
	
}
