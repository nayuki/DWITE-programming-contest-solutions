/* 
 * DWITE - February 2013 - Problem 3: Triangle Count
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201302p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201302p3().run("DATA3.txt", "OUT3.txt");
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
		
		int count = 0;
		// largestTriangle[y][x+1] is the height of the largest triangle with the top at (x, y),
		// thus the size of the largest triangle is max(2*k-1, 0)
		int[][] largestTriangle = new int[n + 1][n + 2];
		for (int y = n - 1; y >= 0; y--) {
			for (int x = 0; x < n; x++) {
				if (grid[y][x] == '#') {
					int min = Integer.MAX_VALUE;
					for (int i = -1; i <= 1; i++)
						min = Math.min(largestTriangle[y + 1][x + 1 + i], min);
					int height = min + 1;
					largestTriangle[y][x + 1] = height;
					count += height;
				}
			}
		}
		io.println(count);
	}
	
}
