/* 
 * DWITE - February 2008 - Problem 1: I heart you
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200802p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200802p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	private static String[] ASCII_ART = {
		" ~.~ ",
		"`   `",
		" \\./ ",
	};
	
	protected void runOnce() {
		int n = io.readIntLine();
		for (String line : ASCII_ART) {
			for (int i = 0; i < n; i++)
				io.print(line);
			io.println();
		}
	}
	
}
