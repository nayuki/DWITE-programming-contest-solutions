/* 
 * DWITE programming contest solutions
 * June 2010 - Problem 5: "Snapper Chain"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201006p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201006p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int n = io.readIntToken();
		int k = io.readIntToken();
		
		// The snappers act like a binary counter.
		// The light is on if and only if k == -1 mod 2^n
		io.println(((k + 1) & ((1 << n) - 1)) == 0 ? "ON" : "OFF");
	}
	
}
