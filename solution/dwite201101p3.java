/* 
 * DWITE - January 2011 - Problem 3: Binary Weight
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201101p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201101p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void runOnce() {
		long n = io.readIntLine();
		
		/* 
		 * Computes the next lexicographical permutation of the bits in n. Examples (in binary):
		 *   0001 --> 0010
		 *   0110 --> 1001
		 *   1011 --> 1101
		 * 
		 * Details of the algorithm:
		 * 0. Take the rightmost 1...10...0 and reverse the string into 0...01...1.
		 * 1. Take the leftmost 1 in this substring and swap it with the 0
		 *    immediately to the left of this substring.
		 * Example: 1000111000 -> 1000000111 -> 1001000011.
		 */
		if (n == 0 || n == -1)
			throw new IllegalArgumentException();
		
		int i = 0;  // Number of rightmost bits processed
		while (((n >>> i) & 1) == 0) i++;  // Skip over rightmost 0s
		
		int j = 0;  // Number of consecutive 1s to the left of rightmost consecutive 0s
		while (((n >>> i) & 1) == 1) { i++; j++; }  // Count consecutive 1s
		
		n &= ~((1L << i) - 1);     // Mask out lower bits
		n |= 1L << i;              // Set relative leading 1
		n |= (1L << (j - 1)) - 1;  // Set trailing 1s
		
		io.println(n);
	}
	
}
