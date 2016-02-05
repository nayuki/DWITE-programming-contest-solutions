/* 
 * DWITE - November 2004 - Problem 1: Credit Card Check Digit
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200411p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200411p1().run("DATA11.txt", "OUT11.txt");
	}
	
	
	protected void runOnce() {
		int[] digits = DwiteAlgorithm.toDigits(io.readLine());
		if (isLuhnValid(digits))
			io.println("VALID");
		else {
			// Try all values for the last digit
			for (int i = 0; i < 10; i++) {
				digits[digits.length - 1] = i;
				if (isLuhnValid(digits)) {  // Guaranteed to execute before the loop ends
					io.printf("INVALID %d%n", digits[digits.length - 1]);
					return;
				}
			}
			throw new AssertionError();
		}
	}
	
	
	private static boolean isLuhnValid(int[] digits) {
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			int d = digits[digits.length - 1 - i];
			if (i % 2 == 0)
				sum += d;
			else
				sum += d / 5 + d % 5 * 2;
		}
		return sum % 10 == 0;
	}
	
}
