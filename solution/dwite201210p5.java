/* 
 * DWITE - October 2012 - Problem 5: Haunted House
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;


public final class dwite201210p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA5.txt", "OUT5.txt", new dwite201210p5());
	}
	
	
	private static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	protected void runOnce() {
		// Read input
		int size = io.readIntLine();
		char[][] grid = io.readGridAndPad(size, size, '#');
		
		// Enumerate candies
		int[][] candyIndex = DwiteAlgorithm.newIntGrid(grid.length, grid[0].length, -1);
		for (int y = 0, numCandies = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x] == '*') {
					candyIndex[y][x] = numCandies;
					numCandies++;
				}
			}
		}
		
		// Initialize visited map
		@SuppressWarnings("unchecked")
		Map<BitSet,Integer>[][] visited = new Map[grid.length][grid[0].length];
		for (int y = 0; y < visited.length; y++) {
			for (int x = 0; x < visited[y].length; x++)
				visited[y][x] = new HashMap<BitSet,Integer>();
		}
		
		// Find starting point
		Queue<Visit> queue = new ArrayDeque<Visit>();
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x] == 'B') {
					BitSet candies = new BitSet();
					visited[y][x].put(candies, 0);
					queue.add(new Visit(x, y, candies));
				}
			}
		}
		
		// Breadth-first search
		int best = 0;  // candies * 256 + (255 - steps)
		while (!queue.isEmpty()) {
			Visit visit = queue.remove();
			BitSet candies = visit.candies;
			int steps = visited[visit.y][visit.x].get(candies);
			best = Math.max(candies.cardinality() << 8 | (0xFF - steps), best);
			for (int[] dir : DIRECTIONS) {
				candies = visit.candies;
				int x = visit.x + dir[0];
				int y = visit.y + dir[1];
				char c = grid[y][x];
				if (c == '#' || c >= 'a' && c <= 'f' && candies.cardinality() < (c - 'a' + 1))
					continue;
				if (c == '*') {
					candies = (BitSet)candies.clone();
					candies.set(candyIndex[y][x]);
				}
				if (!visited[y][x].containsKey(candies)) {
					visited[y][x].put(candies, steps + 1);
					queue.add(new Visit(x, y, candies));
				}
			}
		}
		io.printf("%d %d%n", best >>> 8, 0xFF - (best & 0xFF));
	}
	
	
	
	private static class Visit {
		
		public final int x;
		public final int y;
		public BitSet candies;
		
		
		public Visit(int x, int y, BitSet candies) {
			this.x = x;
			this.y = y;
			this.candies = candies;
		}
		
	}
	
}
