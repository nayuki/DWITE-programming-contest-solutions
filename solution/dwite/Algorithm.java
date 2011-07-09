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
	
}
