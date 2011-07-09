// DWITE - January 2005 - Problem 2: Minesweeper

import dwite.*;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;


public final class dwite200501p2 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA21.txt", "OUT21.txt", new dwite200501p2());
	}
	
	
	public void run(Io io) {
		// Read input
		io.tokenizeLine();
		int h = io.readIntToken();
		int w = io.readIntToken();
		int[][] neighbouringmines = new int[h + 2][w + 2];
		Map<Character,Point> queries = new HashMap<Character,Point>();
		for (int y = 0; y < h; y++) {
			String line = io.readLine();
			for (int x = 0; x < w; x++) {
				char c = line.charAt(x);
				if (c == '.') ;
				else if (c == '*')
					incrementNeighbours(neighbouringmines, x, y);
				else if (c >= 'a' && c <= 'z')
					queries.put(c, new Point(x, y));
				else
					throw new AssertionError("Invalid cell");
			}
		}
		
		// Process queries and write the output
		SortedSet<Character> querykeys = new TreeSet<Character>(queries.keySet());
		for (Character key : querykeys) {
			Point p = queries.get(key);
			int mines = neighbouringmines[p.y + 1][p.x + 1];
			io.printf("%c-%d%n", key, mines);
		}
	}
	
	
	private static void incrementNeighbours(int[][] neighmines, int x, int y) {  // Uses the Moore neighbourhood
		for (int yy = y - 1; yy <= y+1; yy++) {
			for (int xx = x - 1; xx <= x+1; xx++) {
				if (xx != x || yy != y)
					neighmines[yy + 1][xx + 1]++;
			}
		}
	}
	
	
	
	private static class Point {
		
		public final int x;
		public final int y;
		
		
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
		
		public String toString() {
			return String.format("(%d, %d)", x, y);
		}
		
	}
	
}
