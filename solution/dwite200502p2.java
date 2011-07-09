// DWITE - February 2005 - Problem 2: Snakes

import dwite.*;


public final class dwite200502p2 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA21.txt", "OUT21.txt", new dwite200502p2());
	}
	
	
	protected void runOnce(Io io) {
		// Read input
		io.tokenizeLine();
		int height = io.readIntToken();
		int width = io.readIntToken();
		char[][] grid = readGridAndPad(io, width, height, '.');
		
		// Find the largest snakes
		int maxcoiled = 0;
		int maxuncoiled = 0;
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++) {
				int temp = markSnakeAndGetLength(grid, x, y);
				if (isCurrentSnakeCoiled(grid))
					maxcoiled = Math.max(temp, maxcoiled);
				else
					maxuncoiled = Math.max(temp, maxuncoiled);
				clearCurrentSnake(grid);
			}
		}
		
		// Write output
		io.printf("%d %d%n", maxcoiled, maxuncoiled);
	}
	
	
	private static boolean isCurrentSnakeCoiled(char[][] grid) {
		for (int y = 1; y < grid.length - 1; y++) {
			for (int x = 1; x < grid[y].length - 1; x++) {
				if (grid[y][x] == 'O' && countCurrentNeighbours(grid, x, y) >= 3)
					return true;
			}
		}
		return false;
	}
	
	
	private static int markSnakeAndGetLength(char[][] grid, int x, int y) {
		if (grid[y][x] != 'X')
			return 0;
		int count = 1;
		grid[y][x] = 'O';
		count += markSnakeAndGetLength(grid, x - 1, y - 1);
		count += markSnakeAndGetLength(grid, x - 1, y + 0);
		count += markSnakeAndGetLength(grid, x - 1, y + 1);
		count += markSnakeAndGetLength(grid, x + 0, y - 1);
		count += markSnakeAndGetLength(grid, x + 0, y + 1);
		count += markSnakeAndGetLength(grid, x + 1, y - 1);
		count += markSnakeAndGetLength(grid, x + 1, y + 0);
		count += markSnakeAndGetLength(grid, x + 1, y + 1);
		return count;
	}
	
	
	private static int countCurrentNeighbours(char[][] grid, int x, int y) {
		int count = 0;
		if (grid[y - 1][x - 1] == 'O') count++;
		if (grid[y - 1][x + 0] == 'O') count++;
		if (grid[y - 1][x + 1] == 'O') count++;
		if (grid[y + 0][x - 1] == 'O') count++;
		if (grid[y + 0][x + 1] == 'O') count++;
		if (grid[y + 1][x - 1] == 'O') count++;
		if (grid[y + 1][x + 0] == 'O') count++;
		if (grid[y + 1][x + 1] == 'O') count++;
		return count;
	}
	
	
	private static void clearCurrentSnake(char[][] grid) {
		for (int y = 1; y < grid.length - 1; y++) {
			for (int x = 1; x < grid[y].length - 1; x++) {
				if (grid[y][x] == 'O')
					grid[y][x] = '.';
			}
		}
	}
	
	
	
	private static char[][] readGridAndPad(Io io, int width, int height, char border) {
		char[][] map = new char[height + 2][width + 2];
		for (int y = 1; y <= height; y++) {
			String line = io.readLine();
			for (int x = 1; x <= width; x++)
				map[y][x] = line.charAt(x - 1);
			map[y][0] = border;
			map[y][width + 1] = border;
		}
		for (int x = 0; x < width + 2; x++) {
			map[0][x] = border;
			map[height + 1][x] = border;
		}
		return map;
	}
	
}
