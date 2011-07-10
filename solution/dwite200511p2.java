// DWITE - November 2005 - Problem 2: Variations on the Game of Life

import dwite.*;


public final class dwite200511p2 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA21.txt", "OUT21.txt", new dwite200511p2());
	}
	
	
	protected void runOnce() {
		// Read input
		io.tokenizeLine();
		int height = io.readIntToken();
		int width = io.readIntToken();
		char[][] grid = readGridAndPad(io, width, height, ' ');
		
		String rule = io.readLine();
		boolean[] live = parseRule(rule.split("/")[0]);
		boolean[] birth = parseRule(rule.split("/")[1]);
		
		// Compute
		for (int i = 0; i < 25; i++)
			iterate(grid, live, birth);
		
		// Write output
		io.println(countTotalAlive(grid));
	}
	
	
	
	private static void iterate(char[][] grid, boolean[] live, boolean[] birth) {
		char[][] gridnew = new char[grid.length][grid[0].length];
		for (int y = 1; y < grid.length - 1; y++) {
			for (int x = 1; x < grid[0].length - 1; x++) {
				int liveneigh = countLiveNeighbours(grid, x, y);
				if (grid[y][x] == '.' && birth[liveneigh])  // Birth
					gridnew[y][x] = 'X';
				else if (grid[y][x] == 'X' && !live[liveneigh])  // Death
					gridnew[y][x] = '.';
				else  // Unchanged
					gridnew[y][x] = grid[y][x];
			}
		}
		for (int y = 1; y < grid.length - 1; y++) {
			for (int x = 1; x < grid[0].length - 1; x++)
				grid[y][x] = gridnew[y][x];
		}
	}
	
	
	private static int countLiveNeighbours(char[][] grid, int x, int y) {
		int count = 0;
		if (grid[y - 1][x - 1] == 'X') count++;
		if (grid[y - 1][x + 0] == 'X') count++;
		if (grid[y - 1][x + 1] == 'X') count++;
		if (grid[y + 0][x - 1] == 'X') count++;
		if (grid[y + 0][x + 1] == 'X') count++;
		if (grid[y + 1][x - 1] == 'X') count++;
		if (grid[y + 1][x + 0] == 'X') count++;
		if (grid[y + 1][x + 1] == 'X') count++;
		return count;
	}
	
	
	private static int countTotalAlive(char[][] grid) {
		int count = 0;
		for (int y = 1; y < grid.length - 1; y++) {
			for (int x = 1; x < grid[0].length - 1; x++) {
				if (grid[y][x] == 'X')
					count++;
			}
		}
		return count;
	}
	
	
	// For example, turns "235" into [false, false, true, true, false, true, false, false, false]
	private static boolean[] parseRule(String s) {
		boolean[] result = new boolean[9];
		for (int i = 0; i < s.length(); i++)
			result[s.charAt(i) - '0'] = true;
		return result;
	}
	
	
	
	private static char[][] readGridAndPad(Io io, int width, int height, char border) {
		char[][] grid = new char[height + 2][width + 2];
		for (int y = 1; y <= height; y++) {
			String line = io.readLine();
			for (int x = 1; x <= width; x++)
				grid[y][x] = line.charAt(x - 1);
			grid[y][0] = border;
			grid[y][width + 1] = border;
		}
		for (int x = 0; x < width + 2; x++) {
			grid[0][x] = border;
			grid[height + 1][x] = border;
		}
		return grid;
	}
	
}
