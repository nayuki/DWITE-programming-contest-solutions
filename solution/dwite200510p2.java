// DWITE - October 2005 - Problem 2: The Game of Life

import dwite.*;


public final class dwite200510p2 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA21.txt", "OUT21.txt", new dwite200510p2());
	}
	
	
	public void run(Io io) {
		// Read input
		io.tokenizeLine();
		int height = io.readIntToken();
		int width = io.readIntToken();
		char[][] grid = readGridAndPad(io, width, height, '.');
		
		// Compute and write output
		for (int i = 0; i <= 100; i++) {
			if (isBreakpoint(i))
				io.println(countTotalAlive(grid));
			nextGeneration(grid);
		}
	}
	
	
	private static void nextGeneration(char[][] grid) {
		char[][] gridnew = new char[grid.length][grid[0].length];
		for (int y = 1; y < grid.length - 1; y++) {
			for (int x = 1; x < grid[0].length - 1; x++) {
				int liveneigh = countLiveNeighbours(grid, x, y);
				if (grid[y][x] == '.' && liveneigh == 3)  // Birth
					gridnew[y][x] = 'X';
				else if (grid[y][x] == 'X' && (liveneigh < 2 || liveneigh > 3))  // Death
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
	
	
	private static boolean isBreakpoint(int i) {
		return i ==   1
		    || i ==   5
		    || i ==  10
		    || i ==  50
		    || i == 100;
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
