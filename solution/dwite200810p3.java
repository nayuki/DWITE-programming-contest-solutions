/* 
 * DWITE - October 2008 - Problem 3: School's a maze
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayDeque;
import java.util.Queue;


public final class dwite200810p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200810p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	private char[][] grid;
	private int[][] points;  // For letters A to L
	
	protected void run() {
		// Read grid and find points
		grid = io.readGridAndPad(19, 10, '#');
		points = new int[12][];
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				int c = grid[y][x];
				if (c >= 'A' && c <= 'L') {
					int i = c - 'A';
					if (points[i] != null)
						throw new IllegalArgumentException();
					points[i] = new int[]{x, y};
				}
			}
		}
		super.run();
	}
	
	
	protected void runOnce() {
		String line = io.readLine();
		int sum = 0;
		for (int i = 1; i < line.length(); i++)
			sum += distance(points[line.charAt(i - 1) - 'A'], points[line.charAt(i) - 'A']);
		io.println(sum);
	}
	
	
	private int distance(int[] start, int[] end) {
		char[][] tempGrid = grid.clone();
		for (int i = 0; i < tempGrid.length; i++)
			tempGrid[i] = tempGrid[i].clone();
		
		// Breadth-first search
		int[][] distance = DwiteAlgorithm.newIntGrid(grid.length, grid[0].length, Integer.MAX_VALUE);
		Queue<int[]> queue = new ArrayDeque<int[]>();
		tempGrid[start[1]][start[0]] = '#';
		distance[start[1]][start[0]] = 0;
		queue.add(new int[]{start[0], start[1]});
		while (!queue.isEmpty()) {
			int[] point = queue.remove();
			if (point[0] == end[0] && point[1] == end[1])
				return distance[point[1]][point[0]];
			
			for (int[] dir : DwiteAlgorithm.FOUR_DIRECTIONS) {
				int x = point[0] + dir[0];
				int y = point[1] + dir[1];
				int d = distance[point[1]][point[0]] + 1;
				if (tempGrid[y][x] != '#') {
					tempGrid[y][x] = '#';
					distance[y][x] = d;
					queue.add(new int[]{x, y});
				}
			}
		}
		throw new IllegalArgumentException();
	}
	
}
