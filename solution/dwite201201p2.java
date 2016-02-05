/* 
 * DWITE - January 2012 - Problem 2: Prime Time
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Map;
import java.util.TreeMap;


public final class dwite201201p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201201p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	private static int[] smallestPrimeFactor = new int[10001];
	
	static {
		// Modified sieve of Eratosthenes
		for (int i = 2; i < smallestPrimeFactor.length; i++) {
			if (smallestPrimeFactor[i] == 0) {  // i is prime
				for (int j = i; j < smallestPrimeFactor.length; j += i) {
					if (smallestPrimeFactor[j] == 0)
						smallestPrimeFactor[j] = i;
				}
			}
		}
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		Map<Integer,Integer> factors = new TreeMap<Integer,Integer>();
		for (int i = 1; i <= n; i++) {
			int temp = i;
			while (temp != 1) {
				int p = smallestPrimeFactor[temp];
				if (!factors.containsKey(p))
					factors.put(p, 0);
				factors.put(p, factors.get(p) + 1);
				temp /= p;
			}
		}
		
		boolean head = true;
		for (int p : factors.keySet()) {
			if (head)
				head = false;
			else
				io.print(" * ");
			io.print(p + "^" + factors.get(p));
		}
		io.println();
	}
	
}
