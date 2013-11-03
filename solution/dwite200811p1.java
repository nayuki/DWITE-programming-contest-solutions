/* 
 * DWITE - November 2008 - Problem 1: My shiny digital key
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200811p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA1.txt", "OUT1.txt", new dwite200811p1());
	}
	
	
	protected void runOnce() {
		for (int i = 0; i < 7; i++) {
			String line = io.readLine();
			int count = 0;
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == '#')
					count++;
			}
			io.print(count);
		}
		io.println();
		io.readLine();  // Discard blank line
	}
	
}
