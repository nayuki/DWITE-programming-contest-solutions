/* 
 * DWITE - January 2005 - Problem 1: DWITE Golf Tournament
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


public final class dwite200501p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200501p1().run("DATA11.txt", "OUT11.txt");
	}
	
	
	protected void run() {
		// Read input
		int n = io.readIntLine();
		Golfer[] golfers = new Golfer[n];
		for (int i = 0; i < n; i++) {
			String name = io.readLine();
			int score = 0;
			for (int j = 0; j < 9; j++)
				score += io.readIntLine();
			golfers[i] = new Golfer(name, score);
		}
		
		// Sort ascending and write the output
		Arrays.sort(golfers);
		for (int i = 0; i < 5; i++) {
			Golfer golfer = golfers[i];
			io.printf("%s %d%n", golfer.name, golfer.score);
		}
	}
	
	
	
	private static class Golfer implements Comparable<Golfer> {
		
		public final String name;
		public final int score;
		
		
		public Golfer(String name, int score) {
			this.name = name;
			this.score = score;
		}
		
		
		public int compareTo(Golfer g) {
			if (score != g.score)
				return Integer.compare(score, g.score);
			else
				return name.compareTo(g.name);
		}
		
		
		public String toString() {
			return String.format("%s (%d)", name, score);
		}
		
	}
	
}
