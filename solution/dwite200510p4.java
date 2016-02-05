/* 
 * DWITE - October 2005 - Problem 4: Minesweeper
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200510p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200510p4().run("DATA41.txt", "OUT41.txt");
	}
	
	
	private char[][] grid;
	
	
	protected void run() {
		grid = io.readGridAndPad(30, 16, ' ');  // Read grid
		
		// Calculate neighboring mines
		for (int y = 1; y < grid.length - 1; y++) {
			for (int x = 1; x < grid[0].length - 1; x++) {
				if (grid[y][x] == '.')
					grid[y][x] = (char)(getMineNeighborCount(x, y) + '0');
			}
		}
		
		super.run();  // Process queries
	}
	
	
	protected void runOnce() {
		// Read input
		io.tokenizeLine();
		int y = io.readIntToken();  // 1-based index, perfect for the padded grid
		int x = io.readIntToken();
		
		// Make query and write output
		if (grid[y][x] == 'X')
			io.println("MINE - YOU LOSE");
		else if (grid[y][x] >= '1' && grid[y][x] <= '8')
			io.printf("NO MINE - %c SURROUNDING IT%n", grid[y][x]);
		else if (grid[y][x] == '0')
			io.printf("NO MINE - %d SQUARES REVEALED%n", reveal(x, y, new boolean[grid.length][grid[0].length]));
		else
			throw new AssertionError("Invalid cell");
	}
	
	
	private int reveal(int x, int y, boolean[][] visited) {
		if (visited[y][x] || grid[y][x] == ' ')
			return 0;
		if (grid[y][x] == 'X')
			throw new IllegalArgumentException();
		
		visited[y][x] = true;
		int result = 1;
		if (grid[y][x] == '0') {
			for (int[] dir : DwiteAlgorithm.EIGHT_DIRECTIONS)
				result += reveal(x + dir[0], y + dir[1], visited);
		}
		return result;
	}
	
	
	private int getMineNeighborCount(int x, int y) {
		int count = 0;
		for (int[] dir : DwiteAlgorithm.EIGHT_DIRECTIONS) {
			if (grid[y + dir[1]][x + dir[0]] == 'X')
				count++;
		}
		return count;
	}
	
}
