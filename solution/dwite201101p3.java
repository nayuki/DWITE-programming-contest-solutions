// DWITE - January 2011 - Problem 3: Binary Weight
// Solution by Nayuki Minase


public final class dwite201101p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA3.txt", "OUT3.txt", new dwite201101p3());
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		if (n < 0)
			throw new IllegalArgumentException();
		char[] digits = ("0" + Integer.toString(n, 2)).toCharArray();
		
		// Take the rightmost "01" and swap the digits
		for (int i = digits.length - 2; i >= 0; i--) {
			if (digits[i] == '0' && digits[i + 1] == '1') {  // Guaranteed to execute
				digits[i + 0] = '1';
				digits[i + 1] = '0';
				break;
			}
		}
		
		int m = Integer.parseInt(new String(digits), 2);
		io.println(m);
	}
	
}
