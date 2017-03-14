/* 
 * DWITE programming contest solutions
 * December 2008 - Problem 5: "Now in 3D"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


public final class dwite200812p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200812p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	private static int[][] DIRECTIONS = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
	
	protected void runOnce() {
		// Read input
		int size = io.readIntLine();
		char[][][] grid = new char[size + 2][][];
		for (int i = 1; i <= size; i++)  // Read each layer
			grid[i] = io.readGridAndPad(size, size, '#');
		grid[size + 1] = grid[0] = new char[size + 2][size + 2];  // Create padding wall layers
		for (char[] row : grid[0])
			Arrays.fill(row, '#');
		
		// Find start point
		int startX = -1;
		int startY = -1;
		int startZ = -1;
		for (int z = 0; z < grid.length; z++) {
			for (int y = 0; y < grid[z].length; y++) {
				for (int x = 0; x < grid[z][y].length; x++) {
					if (grid[z][y][x] == 'A') {
						startX = x;
						startY = y;
						startZ = z;
						break;
					}
				}
			}
		}
		
		// Breadth-first search
		int[][][] distance = new int[grid.length][grid[0].length][grid[0][0].length];
		for (int[][] layer : distance) {
			for (int[] row : layer)
				Arrays.fill(row, Integer.MAX_VALUE);
		}
		Queue<int[]> queue = new ArrayDeque<>();
		grid[startZ][startY][startX] = '#';
		distance[startZ][startY][startX] = 0;
		queue.add(new int[]{startX, startY, startZ});
		while (!queue.isEmpty()) {
			int[] point = queue.remove();
			for (int[] dir : DIRECTIONS) {
				int x = point[0] + dir[0];
				int y = point[1] + dir[1];
				int z = point[2] + dir[2];
				int d = distance[point[2]][point[1]][point[0]] + 1;
				if (grid[z][y][x] == 'B') {
					io.println(d);
					return;
				} else if (grid[z][y][x] != '#') {
					grid[z][y][x] = '#';
					distance[z][y][x] = d;
					queue.add(new int[]{x, y, z});
				}
			}
		}
		throw new IllegalArgumentException();
	}
	
}
