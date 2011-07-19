// DWITE - December 2010 - Problem 2: Unit rectangles
// Solution by Nayuki Minase


public final class dwite201012p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA2.txt", "OUT2.txt", new dwite201012p2());
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		int count = 0;
		for (int i = 1; i <= n; i++)
			count += countRectangles(i);
		io.println(count);
	}
	
	
	private static int countRectangles(int n) {
		// Find factors
		int m = 0;
		for (int i = 1, end = DwiteAlgorithm.sqrt(n); i <= end; i++) {
			if (n % i == 0)
				m++;
		}
		return m;
	}
	
}
