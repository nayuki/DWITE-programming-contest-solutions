// DWITE - January 2005 - Problem 1: DWITE Golf Tournament

import dwite.*;

import java.util.SortedSet;
import java.util.TreeSet;


public final class dwite200501p1 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA11.txt", "OUT11.txt", new dwite200501p1());
	}
	
	
	public void run() {
		// Read input and sort
		int n = io.readIntLine();
		SortedSet<Golfer> golfers = new TreeSet<Golfer>();
		for (int i = 0; i < n; i++) {
			String name = io.readLine();
			int score = 0;
			for (int j = 0; j < 9; j++)
				score += io.readIntLine();
			golfers.add(new Golfer(name, score));
		}
		
		// Write output
		int i = 0;
		for (Golfer golfer : golfers) {
			if (i == 5)
				break;
			io.printf("%s %d%n", golfer.name, golfer.score);
			i++;
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
				return score - g.score;
			else
				return name.compareTo(g.name);
		}
		
	}
	
}
