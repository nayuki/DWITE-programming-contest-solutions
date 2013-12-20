/* 
 * DWITE - January 2009 - Problem 4: Shortest path around v2
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayDeque;
import java.util.Queue;


public final class dwite200901p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200901p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	protected void runOnce() {
		char[][] grid = io.readGridAndPad(8, 8, '#');
		int[][] distance = DwiteAlgorithm.newIntGrid(grid.length, grid[0].length, Integer.MAX_VALUE);
		
		// Find starting point
		int startX = -1;
		int startY = -1;
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x] == 'A') {
					startX = x;
					startY = y;
					break;
				}
			}
		}
		
		// Breadth-first search on all non-wall cells
		Queue<int[]> queue = new ArrayDeque<int[]>();
		grid[startY][startX] = '#';
		distance[startY][startX] = 0;
		queue.add(new int[]{startX, startY});
		while (!queue.isEmpty()) {
			int[] point = queue.remove();
			for (int[] dir : DwiteAlgorithm.EIGHT_DIRECTIONS) {
				int x = point[0] + dir[0];
				int y = point[1] + dir[1];
				int d = distance[point[1]][point[0]] + 1;
				if (grid[y][x] == 'B') {
					io.println(d);
					return;
				} else if (grid[y][x] != '#') {
					grid[y][x] = '#';
					distance[y][x] = d;
					queue.add(new int[]{x, y});
				}
			}
		}
		throw new IllegalArgumentException();
	}
	
}
