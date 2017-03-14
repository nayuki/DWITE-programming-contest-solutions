/* 
 * DWITE programming contest solutions
 * February 2008 - Problem 4: "Train ride"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public final class dwite200802p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200802p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	protected void runOnce() {
		// Read input and pad with a space on all edges
		List<String> lines = new ArrayList<>();
		lines.add("          ");
		while (true) {
			String line = io.readLine();
			if (line.length() != 10)
				throw new IllegalArgumentException();
			if (line.equals("xxxxxxxxxx"))
				break;
			lines.add(line);
		}
		lines.add("          ");
		char[][] grid = new char[lines.size()][];
		for (int i = 0; i < grid.length; i++)
			grid[i] = (" " + lines.get(i) + " ").toCharArray();
		
		// Find start point
		int startX = -1;
		int startY = -1;
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x] == 'S') {
					startX = x;
					startY = y;
					break;
				}
			}
		}
		
		// Breadth-first search
		int[][] distance = DwiteAlgorithm.newIntGrid(grid.length, grid[0].length, Integer.MAX_VALUE);
		Queue<int[]> queue = new ArrayDeque<>();
		grid[startY][startX] = ' ';
		distance[startY][startX] = 0;
		queue.add(new int[]{startX, startY});
		while (!queue.isEmpty()) {
			int[] point = queue.remove();
			for (int[] dir : DwiteAlgorithm.EIGHT_DIRECTIONS) {
				int x = point[0] + dir[0];
				int y = point[1] + dir[1];
				int d = distance[point[1]][point[0]] + 1;
				if (grid[y][x] == 'E') {
					io.println(d);
					return;
				} else if (grid[y][x] != ' ') {
					grid[y][x] = ' ';
					distance[y][x] = d;
					queue.add(new int[]{x, y});
				}
			}
		}
		throw new IllegalArgumentException();
	}
	
}
