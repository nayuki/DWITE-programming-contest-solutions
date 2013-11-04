/* 
 * DWITE - January 2009 - Problem 5: Blow your mind with 4th D
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.HashSet;
import java.util.Set;


public final class dwite200901p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA5.txt", "OUT5.txt", new dwite200901p5());
	}
	
	
	private static int[][] DIRECTIONS = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	protected void runOnce() {
		// Read input
		int frames = io.readIntLine();
		char[][][] grid = new char[frames][][];
		for (int i = 0; i < frames; i++)  // Read each frame
			grid[i] = io.readGridAndPad(5, 5, '#');
		
		// Find start point
		int startX = -1;
		int startY = -1;
		for (int y = 0; y < grid[0].length; y++) {
			for (int x = 0; x < grid[0][y].length; x++) {
				if (grid[0][y][x] == 'A') {
					startX = x;
					startY = y;
					break;
				}
			}
		}
		
		// Simplified breadth-first search
		Set<Integer> reachable = new HashSet<Integer>();
		reachable.add(startX * 10 + startY);
		for (int i = 0; i + 1 < grid.length; i++) {
			Set<Integer> newReachable = new HashSet<Integer>();
			for (int point : reachable) {
				for (int[] dir : DIRECTIONS) {
					int x = point / 10 + dir[0];
					int y = point % 10 + dir[1];
					if (grid[i + 1][y][x] == 'B') {
						io.println(i + 1);
						return;
					} else if (grid[i + 1][y][x] != '#')
						newReachable.add(x * 10 + y);
				}
			}
			reachable = newReachable;
		}
		throw new IllegalArgumentException();
	}
	
}
