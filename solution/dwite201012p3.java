// DWITE - December 2010 - Problem 3: Dominos Tiling
// Solution by Nayuki Minase


public final class dwite201012p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA3.txt", "OUT3.txt", new dwite201012p3());
	}
	
	
	// dp[i] is the number of ways to tile an (i*2) x 3 rectangle with dominoes
	private static int[] dp;
	
	static {
		dp = new int[16];
		
		// The 0 x 3 empty board can be tiled in one way
		dp[0] = 1;
		
		/*
		 * Tilings for 2 x 3 (all vertically indivisible):
		 * +---+  +-+-+  +---+
		 * |o o|  |o|o|  |o o|
		 * +---+  | | |  +-+-+
		 * |o o|  |o|o|  |o|o|
		 * +---+  +-+-+  | | |
		 * |o o|  |o o|  |o|o|
		 * +---+  +---+  +-+-+
		 */
		dp[1] = 3;
		
		for (int i = 2; i < dp.length; i++) {
			/*
			 * For (i*2) x 3, we have these two vertically indivisible tilings that look like this:
			 * +-+---+-+  +---+---+
			 * |o|o o|o|  |o o|o o|
			 * | +---+ |  +-+---+-+
			 * |o|o o|o|  |o|o o|o|
			 * +-+---+-+  | +---+ |
			 * |o o|o o|  |o|o o|o|
			 * +---+---+  +-+---+-+
			 */
			dp[i] = 2;
			
			// Add the divisible tilings
			for (int j = 1; j < i; j++) {
				dp[i] += dp[j] + dp[i - j];
				dp[i] %= 1000000;
			}
		}
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		if (n % 2 == 0)
			io.println(dp[n / 2]);
		else
			io.println(0);
	}
	
}
