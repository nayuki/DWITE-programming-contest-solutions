/* 
 * DWITE programming contest solutions
 * October 2007 - Problem 5: "Velociraptor Maze"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayDeque;
import java.util.Queue;


public final class dwite200710p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200710p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void run() {
		int height = io.readIntLine();
		int width  = io.readIntLine();
		char[][] grid = io.readGridAndPad(width, height, '#');
		int[][] distance = DwiteAlgorithm.newIntGrid(grid.length, grid[0].length, Integer.MAX_VALUE);
		
		// Find object locations
		int exitX   = -1, exitY   = -1;
		int humanX  = -1, humanY  = -1;
		int raptorX = -1, raptorY = -1;
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[0].length; x++) {
				switch (grid[y][x]) {
					case 'E':
						exitX = x;
						exitY = y;
						break;
					case 'H':
						humanX = x;
						humanY = y;
						break;
					case 'V':
						raptorX = x;
						raptorY = y;
						break;
				}
			}
		}
		
		// Breadth-first search on all non-wall cells
		Queue<int[]> queue = new ArrayDeque<int[]>();
		distance[exitY][exitX] = 0;
		queue.add(new int[]{exitX, exitY});
		while (!queue.isEmpty()) {
			int[] point = queue.remove();
			for (int[] dir : DwiteAlgorithm.FOUR_DIRECTIONS) {
				int x = point[0] + dir[0];
				int y = point[1] + dir[1];
				int d = distance[point[1]][point[0]] + 1;
				if (grid[y][x] != '#' && d < distance[y][x]) {
					distance[y][x] = d;
					queue.add(new int[]{x, y});
				}
			}
		}
		
		// Simulate the chase
		for (int i = 1; ; i++) {
			// Move human once
			for (int[] dir : DwiteAlgorithm.FOUR_DIRECTIONS) {
				int x = humanX + dir[0];
				int y = humanY + dir[1];
				if (distance[y][x] < distance[humanY][humanX]) {
					humanX = x;
					humanY = y;
					break;
				}
			}
			if (humanX == exitX && humanY == exitY && !(raptorX == exitX && raptorY == exitY)) {
				io.println("escape");
				return;
			}
			
			// Move velociraptor twice
			for (int j = 0; j < 2; j++) {
				for (int[] dir : DwiteAlgorithm.FOUR_DIRECTIONS) {
					int x = raptorX + dir[0];
					int y = raptorY + dir[1];
					if (distance[y][x] < distance[raptorY][raptorX]) {
						raptorX = x;
						raptorY = y;
						break;
					}
				}
				if (raptorX == humanX && raptorY == humanY) {
					io.println(i);
					return;
				}
			}
		}
	}
	
}
