/* 
 * DWITE programming contest solutions
 * November 2004 - Problem 2: "Squareland"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200411p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200411p2().run("DATA21.txt", "OUT21.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();  // Total number of lots
		int s = io.readIntLine();  // Size of a lot to choose
		int csqrt = DwiteAlgorithm.sqrt(n) - DwiteAlgorithm.sqrt(s) + 1;  // Number of choices along one dimension
		io.println(csqrt * csqrt);
	}
	
}
