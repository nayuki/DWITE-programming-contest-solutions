/* 
 * DWITE programming contest solutions
 * November 2012 - Problem 3: "Bitstrings"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.math.BigInteger;


public final class dwite201211p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201211p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		BigInteger[] bitStrings = new BigInteger[n + 1];
		bitStrings[0] = BigInteger.ONE;
		bitStrings[1] = BigInteger.ONE;
		bitStrings[2] = BigInteger.ONE;
		for (int i = 3; i <= n; i++)
			bitStrings[i] = bitStrings[i - 2].add(bitStrings[i - 3]);
		io.println(bitStrings[n].toString());
	}
	
}
