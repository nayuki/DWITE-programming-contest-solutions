/* 
 * DWITE programming contest solutions
 * April 2010 - Problem 2: "Round to power of two"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201004p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201004p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		io.println(round(io.readIntLine()));
	}
	
	
	private static int round(int n) {
		return switch (n) {
			case 0  -> 1;
			case 1  -> 1;
			case 2  -> 2;
			case 3  -> 4;
			default -> round(n / 2) * 2;
		};
	}
	
}
