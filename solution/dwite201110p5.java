// DWITE - October 2011 - Problem 5: Tattarrattat
// Solution by Nayuki Minase


public final class dwite201110p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA5.txt", "OUT5.txt", new dwite201110p5());
	}
	
	
	protected void runOnce() {
		String str = io.readLine();
		int n = str.length();
		
		int[][] dp = new int[n + 1][n + 1];  // dp[i][j] is the length of the longest possible palindrome for str.substring(i, j)
		for (int start = 0; start < n; start++)  // Length 1 is obviously a palindrome
			dp[start][start + 1] = 1;
		
		for (int len = 2; len <= n; len++) {
			for (int start = 0; start + len <= n; start++) {
				int end = start + len;
				if (str.charAt(start) == str.charAt(end - 1))
					dp[start][end] = dp[start + 1][end - 1] + 2;
				else
					dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
			}
		}
		
		io.println(dp[0][n]);
	}
	
}
