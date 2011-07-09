package dwite;


public final class Algorithm {
	
	public static int sqrt(int x) {
		if (x < 0)
			throw new IllegalArgumentException();
		int y = 0;
		for (int i = 15; i >= 0; i--) {
			y |= 1 << i;
			if (y > 46340 || y * y > x)
				y ^= 1 << i;
		}
		return y;
	}
	
	
	public static int gcd(int x, int y) {
		while (y != 0) {
			int z = x % y;
			x = y;
			y = z;
		}
		return Math.abs(x);
	}
	
	
	public static int[] toDigits(String str) {
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
