/* 
 * DWITE - October 2005 - Problem 1: Odometers
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.math.BigInteger;


public final class dwite200510p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200510p1().run("DATA11.txt", "OUT11.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		int[] r1 = DwiteAlgorithm.toDigits(io.readLine());  // Base-10 digits in big-endian
		int d1 = io.readIntLine();
		int d2 = io.readIntLine();
		
		// Find the nearest next suitable odometer reading
		int n1 = countOccurrences(r1, d1);
//		int[] r2 = solveSlow(n1, d2, r2);
		int[] r2 = solveFast(r1, n1, d2);
		
		// Compute distance from initial reading to target reading
		BigInteger diff = new BigInteger(toString(r2)).subtract(new BigInteger(toString(r1)));
		diff = diff.mod(BigInteger.TEN.pow(r1.length));
		io.printf("%s %d%n", toString(r2), diff);
	}
	
	
	@SuppressWarnings("unused")
	private static int[] solveSlow(int n1, int d2, int[] r2) {
		while (countOccurrences(r2, d2) != n1)
			increment(r2, r2.length - 1);
		return r2;
	}
	
	
	private static int[] solveFast(int[] r1, int n1, int d2) {
		int[] r2 = r1.clone();
		while (true) {
			int n2 = countOccurrences(r2, d2);
			if (n2 == n1)  // Done!
				break;
			else if (n2 < n1) {
				// Try to set a lower-order non-d2 digit to d2
				for (int i = r2.length - 1; i >= 0; i--) {
					if (r2[i] < d2) {
						// Set digit directly to d2. n2 will be incremented.
						r2[i] = d2;
						break;
					} else if (r2[i] > d2) {
						// Increment next digit, clear this digit and all digits below. n2 will decrease or stay the same.
						increment(r2, i - 1);
						for (; i < r2.length; i++)
							r2[i] = 0;
						break;
					}
				}
			} else {  // n2 > n1
				// Increment a lower-order d2. n2 will be decremented or stay the same.
				for (int i = r2.length - 1; i >= 0; i--) {
					if (r2[i] == d2) {
						increment(r2, i);
						break;
					}
				}
			}
		}
		return r2;
	}
	
	
	private static void increment(int[] digits, int index) {
		while (true) {
			if (index < 0)
				return;
			else if (digits[index] != 9)
				break;
			else {
				digits[index] = 0;
				index--;
			}
		}
		digits[index]++;
	}
	
	
	private static int countOccurrences(int[] digits, int val) {
		int count = 0;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == val)
				count++;
		}
		return count;
	}
	
	
	private static String toString(int[] digits) {
		char[] temp = new char[digits.length];
		for (int i = 0; i < digits.length; i++)
			temp[i] = (char)('0' + digits[i]);
		return new String(temp);
	}
	
}
