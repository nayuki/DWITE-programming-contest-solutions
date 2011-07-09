// DWITE - November 2004 - Problem 1: Credit Card Check Digit

import dwite.*;


public final class dwite200411p1 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA11.txt", "OUT11.txt", new dwite200411p1());
	}
	
	
	protected void runOnce(Io io) {
		int[] digits = toDigits(io.readLine());
		int sum = getLuhnSum(digits);
		if (sum % 10 == 0)
			io.println("VALID");
		else {
			// Try all values for the last digit
			for (int i = 0; i < 10; i++) {
				digits[digits.length - 1] = i;
				if (getLuhnSum(digits) % 10 == 0) {  // Guaranteed to execute before the loop ends
					io.printf("INVALID %d%n", digits[digits.length - 1]);
					break;
				}
			}
		}
	}
	
	
	private static int getLuhnSum(int[] digits) {
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			if ((i + digits.length) % 2 == 1)
				sum += digits[i];
			else
				sum += digits[i] / 5 + digits[i] % 5 * 2;
		}
		return sum;
	}
	
	
	
	private static int[] toDigits(String str) {
		int[] digits = new int[str.length()];
		for (int i = 0; i < digits.length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9')
				throw new IllegalArgumentException();
			digits[i] = c - '0';
		}
		return digits;
	}
	
}