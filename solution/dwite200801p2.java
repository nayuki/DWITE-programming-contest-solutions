/* 
 * DWITE - January 2008 - Problem 2: And the winner is...
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


public final class dwite200801p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200801p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		HighScore[] hs = new HighScore[5];
		for (int i = 0; i < hs.length; i++) {
			String[] tok = io.readLine().split(" ", 2);
			int score = Integer.parseInt(tok[0]);
			String name = tok[1];
			hs[i] = new HighScore(score, name);
		}
		Arrays.sort(hs);  // Stable as promised by the API
		for (HighScore h : hs)
			io.println(h.name);
	}
	
	
	
	private static class HighScore implements Comparable<HighScore> {
		
		public final int score;
		public final String name;
		
		
		public HighScore(int score, String name) {
			this.score = score;
			this.name = name;
		}
		
		
		public int compareTo(HighScore other) {
			return Integer.compare(other.score, score);  // Descending order
		}
		
	}
	
}
