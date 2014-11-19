/* 
 * DWITE - October 2005 - Problem 2: The Game of Life
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200510p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200510p2().run("DATA21.txt", "OUT21.txt");
	}
	
	
	private char[][] grid;
	
	
	protected void run() {
		// Read input
		io.tokenizeLine();
		int height = io.readIntToken();
		int width = io.readIntToken();
		grid = io.readGridAndPad(width, height, '.');
		
		// Compute and write output
		for (int i = 0; i < 100; i++) {
			int alive = nextGeneration();
			if (isBreakpoint(i + 1))
				io.println(alive);
		}
	}
	
	
	private int nextGeneration() {
		int alive = 0;
		char[][] newGrid = new char[grid.length][grid[0].length];
		for (int y = 1; y < grid.length - 1; y++) {
			for (int x = 1; x < grid[0].length - 1; x++) {
				int liveneigh = countLiveNeighbors(x, y);
				if (liveneigh == 3 || grid[y][x] == 'X' && liveneigh == 2) {
					newGrid[y][x] = 'X';
					alive++;
				} else
					newGrid[y][x] = '.';
			}
		}
		grid = newGrid;
		return alive;
	}
	
	
	private int countLiveNeighbors(int x, int y) {
		int count = 0;
		for (int[] dir : DwiteAlgorithm.EIGHT_DIRECTIONS) {
			if (grid[y + dir[1]][x + dir[0]] == 'X')
				count++;
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
	
}
