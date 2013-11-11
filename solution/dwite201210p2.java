/* 
 * DWITE - October 2012 - Problem 2: Candybar Graphs
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201210p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA2.txt", "OUT2.txt", new dwite201210p2());
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int x = io.readIntToken();
		int y = io.readIntToken();
		int n = x * 10 / (x + y);
		int i;
		for (i = 0; i < n; i++)
			io.print("*");
		for (; i < 10; i++)
			io.print(".");
		io.println();
	}
	
}
