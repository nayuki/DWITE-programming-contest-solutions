// DWITE - December 2004 - Problem 2: Squareland II

import dwite.*;


public final class dwite200412p2 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA21.txt", "OUT21.txt", new dwite200412p2());
	}
	
	
	protected void runOnce(Io io) {
		// Read input
		int n = io.readIntLine();
		int s = io.readIntLine();
		int sqrtn = sqrt(n);
		int sqrts = sqrt(s);
		int[][] grid = new int[sqrtn][sqrtn];
		for (int y = 0; y < grid.length; y++) {
			io.tokenizeLine();
			for (int x = 0; x < grid[y].length; x++)
				grid[y][x] = io.readIntToken();
		}
		
		// Find square with maximum sum
		int maxsum = 0;
		for (int y = 0; y+sqrts <= sqrtn; y++) {
			for (int x = 0; x+sqrts <= sqrtn; x++)
				maxsum = Math.max(sum(grid, x, y, sqrts, sqrts), maxsum);
		}
		
		// Write output
		io.println(maxsum);
	}
	
	
	private static int sum(int[][] map, int x, int y, int w, int h) {
		int sum = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++)
				sum += map[y + i][x + j];
		}
		return sum;
	}
	
	
	
	private static int sqrt(int x) {
		int y = 0;
		for (int i = 15; i >= 0; i--) {
			y |= 1 << i;
			if (y > 46340 || y * y > x)
				y ^= 1 << i;
		}
		return y;
	}
	
}