/* 
 * DWITE - December 2010 - Problem 1: Integers along a line
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201012p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201012p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int a = io.readIntToken();
		int b = io.readIntToken();
		int x = io.readIntToken();
		int y = io.readIntToken();
		io.println(DwiteAlgorithm.gcd(a - x, b - y) - 1);
	}
	
}
