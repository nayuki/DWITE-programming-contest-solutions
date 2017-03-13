/* 
 * DWITE programming contest solutions
 * January 2007 - Problem 2: "Minesweeper"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;


public final class dwite200701p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200701p2().run("DATA21.txt", "OUT21.txt");
	}
	
	
private char[][] grid;
	
	
	protected void run() {
		// Read input
		io.tokenizeLine();
		int h = io.readIntToken();
		int w = io.readIntToken();
		grid = new char[h + 2][w + 2];  // Padded
		Map<Character,Point> queries = new HashMap<Character,Point>();
		for (int y = 0; y < h; y++) {
			String line = io.readLine();
			for (int x = 0; x < w; x++) {
				char c = line.charAt(x);
				if (c >= 'a' && c <= 'z')
					queries.put(c, new Point(x, y));
				else if (c != '.' && c != '*')
					throw new AssertionError("Invalid cell");
				grid[y + 1][x + 1] = c;
			}
		}
		
		// Process queries and write output
		SortedSet<Character> querykeys = new TreeSet<Character>(queries.keySet());
		for (Character key : querykeys) {
			Point p = queries.get(key);
			int mines = countNeighborMines(p.x, p.y);
			io.printf("%c-%d%n", key, mines);
		}
	}
	
	
	private int countNeighborMines(int x, int y) {
		int count = 0;
		for (int[] dxy : DwiteAlgorithm.EIGHT_DIRECTIONS) {
			if (grid[y + 1 + dxy[1]][x + 1 + dxy[0]] == '*')
				count++;
		}
		return count;
	}
	
	
	
	private static final class Point {
		
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
