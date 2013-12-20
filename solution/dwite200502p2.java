import java.util.ArrayDeque;
import java.util.Queue;

/* 
 * DWITE - February 2005 - Problem 2: Snakes
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200502p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200502p2().run("DATA21.txt", "OUT21.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		io.tokenizeLine();
		int height = io.readIntToken();
		int width = io.readIntToken();
		char[][] grid = io.readGridAndPad(width, height, '.');
		
		// Find the largest snakes
		int maxcoiled = 0;
		int maxuncoiled = 0;
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++) {
				if (grid[y][x] == 'X') {
					Object[] temp = markSnake(grid, x, y);
					if ((Boolean)temp[0])
						maxcoiled = Math.max((Integer)temp[1], maxcoiled);
					else
						maxuncoiled = Math.max((Integer)temp[1], maxuncoiled);
				}
			}
		}
		io.printf("%d %d%n", maxcoiled, maxuncoiled);
	}
	
	
	private static Object[] markSnake(char[][] grid, int x, int y) {
		boolean coiled = false;
		int count = 0;
		
		// Breadth-first search
		Queue<int[]> queue = new ArrayDeque<int[]>();
		grid[y][x] = 'O';
		queue.add(new int[]{x, y});
		while (!queue.isEmpty()) {
			int[] point = queue.remove();
			count++;
			int neighbors = 0;
			for (int[] dir : DwiteAlgorithm.EIGHT_DIRECTIONS) {
				x = point[0] + dir[0];
				y = point[1] + dir[1];
				if (grid[y][x] != '.') {
					neighbors++;
					if (grid[y][x] == 'X') {
						grid[y][x] = 'O';
						queue.add(new int[]{x, y});
					}
				}
			}
			if (neighbors >= 3)
				coiled = true;
		}
		
		return new Object[]{coiled, count};
	}
	
}
