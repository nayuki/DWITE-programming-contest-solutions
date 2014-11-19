/* 
 * DWITE - January 2010 - Problem 1: Social Media Overload
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201001p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201001p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		io.println(Math.round((double)30 * 5 * 60 / n));
	}
	
}
