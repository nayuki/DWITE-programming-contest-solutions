/* 
 * DWITE - October 2012 - Problem 1: Candy Piles
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201210p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201210p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++)
				io.print("*");
			io.println();
		}
		for (int i = n; i >= 1; i--) {
			for (int j = 0; j < i; j++)
				io.print("*");
			io.println();
		}
	}
	
}
