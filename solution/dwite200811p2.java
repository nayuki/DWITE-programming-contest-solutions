/* 
 * DWITE programming contest solutions
 * November 2008 - Problem 2: "My favourite digit"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200811p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200811p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		int max = 0;
		for (; n > 0; n /= 10)
			max = Math.max(n % 10, max);
		io.println(max);
	}
	
}
