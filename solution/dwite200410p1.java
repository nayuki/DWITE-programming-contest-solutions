/* 
 * DWITE - October 2004 - Problem 1: Area of Circle
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200410p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200410p1().run("DATA1", "OUT1");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		double x1 = io.readDoubleToken();
		double y1 = io.readDoubleToken();
		double x2 = io.readDoubleToken();
		double y2 = io.readDoubleToken();
		io.printf("%.3f%n", 3.14159 * ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
	}
	
}
