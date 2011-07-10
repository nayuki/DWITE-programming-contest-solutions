// DWITE - October 2005 - Problem 4: Minesweeper

import dwite.*;


public final class dwite200510p4 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA41.txt", "OUT41.txt", new dwite200510p4());
	}
	
	
	private char[][] grid;
	
	
	public void run() {
		grid = readGridAndPad(io, 30, 16, ' ');  // Read grid
		calculateNeighboringMines(grid);  // Process grid
		super.run();  // Process queries
	}
	
	
	protected void runOnce() {
		// Read input
		io.tokenizeLine();
		int y = io.readIntToken();
		int x = io.readIntToken();
		
		// Make query and write output
		if (grid[y][x] == 'X')
			io.println("MINE - YOU LOSE");
		else if (grid[y][x] >= '1' && grid[y][x] <= '8')
			io.printf("NO MINE - %c SURROUNDING IT%n", grid[y][x]);
		else if (grid[y][x] == '0')
			io.printf("NO MINE - %d SQUARES REVEALED%n", reveal(grid, x, y, new boolean[grid.length][grid[0].length]));
		else
			throw new AssertionError("Invalid cell");
	}
	
	
	private static int reveal(char[][] grid, int x, int y, boolean[][] visited) {
		if (visited[y][x] || grid[y][x] == ' ')
			return 0;
		visited[y][x] = true;
		int result = 1;
		if (grid[y][x] == '0') {
			result += reveal(grid, x - 1, y - 1, visited);
			result += reveal(grid, x + 0, y - 1, visited);
			result += reveal(grid, x + 1, y - 1, visited);
			result += reveal(grid, x - 1, y + 0, visited);
			result += reveal(grid, x + 1, y + 0, visited);
			result += reveal(grid, x - 1, y + 1, visited);
			result += reveal(grid, x + 0, y + 1, visited);
			result += reveal(grid, x + 1, y + 1, visited);
		}
		return result;
	}
	
	
	private static void calculateNeighboringMines(char[][] grid) {
		for (int y = 1; y < grid.length - 1; y++) {
			for (int x = 1; x < grid[0].length - 1; x++) {
				if (grid[y][x] == '.')
					grid[y][x] = (char)(getMineNeighborCount(grid, x, y) + '0');
			}
		}
	}
	
	
	private static int getMineNeighborCount(char[][] grid, int x, int y) {
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
