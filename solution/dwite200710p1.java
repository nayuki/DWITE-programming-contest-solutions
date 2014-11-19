/* 
 * DWITE - October 2007 - Problem 1: Vanilla Primes
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200710p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200710p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void run() {
		int n = io.readIntLine();
		if (n < 2)
			io.println("not");
		else {
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					io.println("not");
					return;
				}
			}
			io.println("prime");
		}
	}
	
}
