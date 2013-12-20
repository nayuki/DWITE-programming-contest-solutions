/* 
 * DWITE - February 2013 - Problem 4: Fencing Problems
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201302p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201302p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	private static int[][] DIAGONAL_DIRECTIONS = {{-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
	
	protected void runOnce() {
		int size = io.readIntLine();
		char[][] grid = new char[size][];
		for (int y = 0; y < grid.length; y++) {
			grid[y] = io.readLine().toCharArray();
			if (grid[y].length != size)
				throw new IllegalArgumentException();
		}
		
		int count = 0;
		for (int y = -1; y <= size; y++) {
			for (int x = -1; x <= size; x++) {
				if (x >= 0 && x < size && y >= 0 && y < size && grid[y][x] == '#')
					continue;
				int neighbors = 0;
				int axesNeighbors = 0;
				for (int[] dir : DwiteAlgorithm.FOUR_DIRECTIONS) {
					int u = x + dir[0];
					int v = y + dir[1];
					if (u >= 0 && u < size && v >= 0 && v < size && grid[v][u] == '#') {
						neighbors++;
						axesNeighbors++;
					}
				}
				for (int[] dir : DIAGONAL_DIRECTIONS) {
					int u = x + dir[0];
					int v = y + dir[1];
					if (u >= 0 && u < size && v >= 0 && v < size && grid[v][u] == '#')
						neighbors++;
				}
				if (neighbors > 0 && axesNeighbors <= 1)
					count++;
			}
		}
		io.println(count);
	}
	
}
