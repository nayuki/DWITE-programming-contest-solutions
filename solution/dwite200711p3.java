/* 
 * DWITE - November 2007 - Problem 3: Floor Plan
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


public final class dwite200711p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200711p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void run() {
		int height = io.readIntLine();
		int width  = io.readIntLine();
		char[][] grid = io.readGridAndPad(width, height, '#');
		
		int[] roomArea = new int[5];
		Arrays.fill(roomArea, -1);
		
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				char c = grid[y][x];
				if (c != '#') {
					// Breadth-first search
					int room = -1;
					int area = 1;
					Queue<int[]> queue = new ArrayDeque<int[]>();
					if (c >= '1' && c <= '5')
						room = c - '1';
					grid[y][x] = '#';
					queue.add(new int[]{x, y});
					while (!queue.isEmpty()) {
						int[] point = queue.remove();
						for (int[] dir : DwiteAlgorithm.FOUR_DIRECTIONS) {
							int nextX = point[0] + dir[0];
							int nextY = point[1] + dir[1];
							c = grid[nextY][nextX];
							if (c != '#') {
								if (c >= '1' && c <= '5') {
									if (room != -1)
										throw new IllegalArgumentException();
									room = c - '1';
								}
								grid[nextY][nextX] = '#';
								area++;
								queue.add(new int[]{nextX, nextY});
							}
						}
					}
					if (roomArea[room] != -1)
						throw new IllegalArgumentException();
					roomArea[room] = area;
				}
			}
		}
		
		for (int area : roomArea)
			io.println(area);
	}
	
}
