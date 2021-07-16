/* 
 * DWITE programming contest solutions
 * January 2007 - Problem 2: "Minesweeper"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


public final class dwite200701p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200701p2().run("DATA21.txt", "OUT21.txt");
	}
	
	
	protected void run() {
		// Read input
		io.tokenizeLine();
		int h = io.readIntToken();
		int w = io.readIntToken();
		char[][] grid = io.readGridAndPad(w, h, '.');
		
		// Find and process queries
		int[] queriedMines = new int[5];
		Arrays.fill(queriedMines, -1);
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				char c = grid[y + 1][x + 1];
				if (c >= 'a' && c - 'a' < queriedMines.length) {
					if (queriedMines[c - 'a'] != -1)
						throw new IllegalArgumentException();
					queriedMines[c - 'a'] = countNeighborMines(grid, x, y);
				}
			}
		}
		
		// Write output
		for (int i = 0; i < queriedMines.length; i++)
			io.printf("%c-%d%n", (char)('a' + i), queriedMines[i]);
	}
	
	
	private static int countNeighborMines(char[][] grid, int x, int y) {
		int count = 0;
		for (int[] dxy : DwiteAlgorithm.EIGHT_DIRECTIONS) {
			if (grid[y + 1 + dxy[1]][x + 1 + dxy[0]] == '*')
				count++;
		}
		return count;
	}
	
}
