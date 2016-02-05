/* 
 * DWITE - October 2012 - Problem 3: Costume Party
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.HashSet;
import java.util.Set;


public final class dwite201210p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201210p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void runOnce() {
		Set<String> seen = new HashSet<String>();
		boolean isOutputEmpty = true;
		int n = io.readIntLine();
		for (int i = 0; i < n; i++) {
			io.tokenizeLine();
			String name = io.readToken();
			String costume = io.readToken();
			if (seen.contains(costume)) {
				if (isOutputEmpty)
					isOutputEmpty = false;
				else
					io.print(" ");
				io.print(name);
			} else
				seen.add(costume);
		}
		if (isOutputEmpty)
			io.println("SPOOKY");
		else
			io.println();
	}
	
}
