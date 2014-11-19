/* 
 * DWITE - October 2006 - Problem 5: Bad Input II
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.math.BigInteger;


public final class dwite200610p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200610p5().run("DATA51.txt", "OUT51.txt");
	}
	
	
	protected void runOnce() {
		String a = io.readLine().replaceAll("[^0-9]", "");
		String b = io.readLine().replaceAll("[^0-9]", "");
		io.println(new BigInteger(a).add(new BigInteger(b)).toString());
	}
	
}
