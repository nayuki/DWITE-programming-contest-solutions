/* 
 * DWITE - November 2008 - Problem 5: Water damage
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200811p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA5.txt", "OUT5.txt", new dwite200811p5());
	}
	
	
	protected void runOnce() {
		int water  = io.readIntLine();
		int width  = io.readIntLine();
		int height = io.readIntLine();
		char[][] grid = io.readGridAndPad(width, height, '#');
		int submerged = 0;
		for (int i = 0; i < water; i++) {
			int x = 1;
			int y = 1;
			while (true) {
				boolean moved = false;
				while (grid[y + 1][x] != '#') {  // Fall down
					y++;
					moved = true;
				}
				// Flow across
				if (grid[y][x + 1] != '#') {
					x++;
					moved = true;
				}
				if (!moved)
					break;
			}
			if (grid[y][x] == 'A')
				submerged++;
			grid[y][x] = '#';
		}
		io.println(submerged);
		io.readLine();  // Discard blank line
	}
	
}
