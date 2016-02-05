/* 
 * DWITE - January 2005 - Problem 5: Different Bases Multiplication
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200501p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200501p5().run("DATA51.txt", "OUT51.txt");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		String xstr = io.readToken();
		int xbase = io.readIntToken();
		int x = Integer.parseInt(xstr, xbase);
		
		io.tokenizeLine();
		String ystr = io.readToken();
		int ybase = io.readIntToken();
		int y = Integer.parseInt(ystr, ybase);
		
		int outbase = io.readIntLine();
		io.println(Integer.toString(x * y, outbase));
	}
	
}
