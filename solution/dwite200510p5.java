/* 
 * DWITE - October 2005 - Problem 5: Five Digit Divisibility
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200510p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200510p5().run("DATA51.txt", "OUT51.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		io.tokenizeLine();
		int numDigits = io.readIntToken();
		int divisor = io.readIntToken();
		
		// Compute
		int[] digits = new int[numDigits];
		int count = 0;
		for (int i = 0; i < FACTORIAL[numDigits]; i++) {
			for (int j = 0; j < numDigits; j++)
				digits[j] = j + 1;
			permute(digits, i);
			if (toNumber(digits) % divisor == 0)
				count++;
		}
		io.println(count);
	}
	
	
	private static void permute(int[] array, int perm) {
		// A modification of the Knuth shuffle
		for (int i = array.length - 1; i >= 0; i--) {
			int j = perm % (i + 1);
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			perm /= i + 1;
		}
	}
	
	
	private static int toNumber(int[] digits) {
		int num = 0;
		for (int i = digits.length - 1; i >= 0; i--)
			num = num * 10 + digits[i];
		return num;
	}
	
	
	private static final int[] FACTORIAL = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	
}
