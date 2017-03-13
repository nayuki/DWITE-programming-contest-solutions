/* 
 * DWITE programming contest solutions
 * January 2008 - Problem 4: "Shortest path around"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayDeque;
import java.util.Queue;


public final class dwite200801p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200801p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	protected void runOnce() {
		char[][] grid = io.readGridAndPad(10, 10, '#');
		int[][] distance = DwiteAlgorithm.newIntGrid(grid.length, grid[0].length, Integer.MAX_VALUE);
		
		// Find one endpoint
		int startX = -1;
		int startY = -1;
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x] == 'X') {
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
		boolean done = false;
		while (!queue.isEmpty() && !done) {
			int[] point = queue.remove();
			for (int[] dir : DwiteAlgorithm.EIGHT_DIRECTIONS) {
				int x = point[0] + dir[0];
				int y = point[1] + dir[1];
				int d = distance[point[1]][point[0]] + 1;
				if (grid[y][x] == 'X') {
					io.println(d);
					done = true;
					break;
				} else if (grid[y][x] != '#') {
					grid[y][x] = '#';
					distance[y][x] = d;
					queue.add(new int[]{x, y});
				}
			}
		}
		if (!done)
			throw new IllegalArgumentException();
		io.readLine();  // Discard line of dashes
	}
	
}
