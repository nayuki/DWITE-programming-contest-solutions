/* 
 * DWITE - January 2005 - Problem 2: Minesweeper
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


public final class dwite200501p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200501p2().run("DATA21.txt", "OUT21.txt");
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
	
	
	// Uses the Moore/8-cell neighbourhood
	private static int countNeighborMines(char[][] grid, int x, int y) {
		int count = 0;
		for (int dy = -1; dy <= 1; dy++) {
			for (int dx = -1; dx <= 1; dx++) {
				if ((dx != 0 || dy != 0) && grid[y + 1 + dy][x + 1 + dx] == '*')
					count++;
			}
		}
		return count;
	}
	
}
