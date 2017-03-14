/* 
 * DWITE programming contest solutions
 * December 2007 - Problem 5: "Portals"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayDeque;
import java.util.Queue;


public final class dwite200712p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200712p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	private char[][] grid;
	
	protected void run() {
		int height = io.readIntLine();
		int width  = io.readIntLine();
		grid = io.readGridAndPad(width, height, '#');
		
		for (int i = 0; i < 5; i++) {  // For each room
			char[][] tempGrid = grid.clone();
			for (int j = 0; j < tempGrid.length; j++)
				tempGrid[j] = tempGrid[j].clone();
			
			// Breadth-first search
			int[] point = find((char)('1' + i));
			int area = 1;
			Queue<int[]> queue = new ArrayDeque<>();
			tempGrid[point[1]][point[0]] = '#';
			queue.add(point);
			while (!queue.isEmpty()) {
				point = queue.remove();
				for (int[] dir : DwiteAlgorithm.FOUR_DIRECTIONS) {
					int nextX = point[0] + dir[0];
					int nextY = point[1] + dir[1];
					char c = tempGrid[nextY][nextX];
					if (c != '#') {
						area++;
						queue.add(new int[]{nextX, nextY});
						tempGrid[nextY][nextX] = '#';
						if (c >= 'a' && c <= 'j') {
							int[] p = find((char)(c - 'a' + 'A'));
							area++;
							queue.add(p);  // Convert to uppercase
							tempGrid[p[1]][p[0]] = '#';
						}
					}
				}
			}
			io.println(area);
		}
	}
	
	
	private int[] find(char c) {
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x] == c)
					return new int[]{x, y};
			}
		}
		throw new IllegalArgumentException();
	}
	
}
