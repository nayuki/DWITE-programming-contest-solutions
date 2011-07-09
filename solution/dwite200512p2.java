// DWITE - December 2005 - Problem 2: The Maze

import dwite.*;

import java.util.LinkedList;
import java.util.Queue;


public final class dwite200512p2 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA21.txt", "OUT21.txt", new dwite200512p2());
	}
	
	
	protected void runOnce(Io io) {
		// Read input
		io.tokenizeLine();
		int height = io.readIntToken();
		int width = io.readIntToken();
		char[][] grid = readGridAndPad(io, width, height, '#');
		
		// Find entry cell position
		int startx = -1;
		int starty = -1;
		outer:
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++) {
				if (grid[y][x] == 'E') {
					startx = x;
					starty = y;
					break outer;
				}
			}
		}
		
		// Compute shortest path length
		// int length = findShortestPathDfs(grid, startx, starty);
		int length = findShortestPathBfs(grid, startx, starty);
		
		// Write output
		io.println(length - 1);  // The number of dots is length-1
	}
	
	
	@SuppressWarnings("unused")
	private static int findShortestPathDfs(char[][] grid, int x, int y) {
		if (grid[y][x] == 'X')
			return 0;
		if (grid[y][x] == '#')
			return Integer.MAX_VALUE / 2;
		
		int min = Integer.MAX_VALUE / 2;  // Length of the rest of the path
		grid[y][x] = '#';
		min = Math.min(findShortestPathDfs(grid, x - 1, y + 0), min);
		min = Math.min(findShortestPathDfs(grid, x + 1, y + 0), min);
		min = Math.min(findShortestPathDfs(grid, x + 0, y - 1), min);
		min = Math.min(findShortestPathDfs(grid, x + 0, y + 1), min);
		grid[y][x] = '.';
		return 1 + min;
	}
	
	
	private static int findShortestPathBfs(char[][] grid, int startx, int starty) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(startx, starty, 0));
		while (true) {
			Point cell = queue.poll();
			if (cell == null)
				throw new AssertionError("No path exists");
			int x = cell.x;
			int y = cell.y;
			int dist = cell.distance;
			if (grid[y][x] == 'X')
				return cell.distance;
			else if (grid[y][x] == '#')
				continue;
			else {
				grid[y][x] = '#';
				queue.offer(new Point(x - 1, y + 0, dist + 1));
				queue.offer(new Point(x + 1, y + 0, dist + 1));
				queue.offer(new Point(x + 0, y - 1, dist + 1));
				queue.offer(new Point(x + 0, y + 1, dist + 1));
			}
		}
	}
	
	
	
	private static char[][] readGridAndPad(Io io, int width, int height, char border) {
		char[][] grid = new char[height + 2][width + 2];
		for (int y = 1; y <= height; y++) {
			String line = io.readLine();
			for (int x = 1; x <= width; x++)
				grid[y][x] = line.charAt(x - 1);
			grid[y][0] = border;
			grid[y][width + 1] = border;
		}
		for (int x = 0; x < width + 2; x++) {
			grid[0][x] = border;
			grid[height + 1][x] = border;
		}
		return grid;
	}
	
	
	
	private static class Point {
		
		public final int x;
		public final int y;
		public final int distance;
		
		
		
		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.distance = dist;
		}
		
		
		
		public String toString() {
			return String.format("(%d, %d)", x, y);
		}
		
	}
	
}
