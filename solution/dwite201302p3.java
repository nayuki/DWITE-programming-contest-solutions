/* 
 * DWITE - February 2013 - Problem 3: Triangle Count
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201302p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA3.txt", "OUT3.txt", new dwite201302p3());
	}
	
	
	protected void runOnce() {
		// Read grid
		int n = io.readIntLine();
		char[][] grid = new char[n][];
		for (int y = 0; y < n; y++) {
			grid[y] = io.readLine().toCharArray();
			if (grid[y].length != n)
				throw new IllegalArgumentException();
		}
		
		// Cumulative row sums
		int[][] cumSum = new int[n][n + 1];
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++)
				cumSum[y][x + 1] = cumSum[y][x] + (grid[y][x] == '#' ? 1 : 0);
		}
		
		// Count triangles of all possible sizes and positions
		int count = 0;
		for (int size = 1; size <= n; size += 2) {
			int height = size / 2 + 1;
			for (int y = 0; y + height <= n; y++) {
				for (int x = 0; x + size <= n; x++) {
					if (hasTriangle(cumSum, size, x, y))
						count++;
				}
			}
		}
		io.println(count);
	}
	
	
	private static boolean hasTriangle(int[][] cumSum, int size, int x, int y) {
		int height = size / 2 + 1;
		for (int i = 0; i < height; i++) {
			int width = i * 2 + 1;
			int offset = x + height - 1 - i;
			int row = y + i;
			if (cumSum[row][offset + width] - cumSum[row][offset] < width)
				return false;
		}
		return true;
	}
	
}
