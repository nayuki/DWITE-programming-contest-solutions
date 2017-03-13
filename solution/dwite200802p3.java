/* 
 * DWITE programming contest solutions
 * February 2008 - Problem 3: "Parity bit"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
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
