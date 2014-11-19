/* 
 * DWITE - November 2008 - Problem 5: Water damage
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200811p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200811p5().run("DATA5.txt", "OUT5.txt");
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
