/* 
 * DWITE - February 2008 - Problem 3: Parity bit
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200802p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200802p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void runOnce() {
		io.println(Integer.bitCount(io.readIntLine()) % 2);
	}
	
}
