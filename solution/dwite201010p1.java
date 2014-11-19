/* 
 * DWITE - October 2010 - Problem 1: Age Gate
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201010p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201010p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int d = io.readIntToken();
		int m = io.readIntToken();
		int y = io.readIntToken();
		
		// Test if (y, m, d) <= (2010 - 13, 10, 27)
		boolean oldEnough =    y < 1997
		                    || y == 1997 && m < 10
		                    || y == 1997 && m == 10 && d <= 27;
		io.println(oldEnough ? "old enough" : "too young");
	}
	
}
