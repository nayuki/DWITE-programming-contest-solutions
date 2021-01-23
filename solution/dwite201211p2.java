/* 
 * DWITE programming contest solutions
 * November 2012 - Problem 2: "Word Arithmetic"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.math.BigInteger;


public final class dwite201211p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201211p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	private static final BigInteger BASE = BigInteger.valueOf(26);
	
	protected void runOnce() {
		BigInteger sum = BigInteger.ZERO;
		io.tokenizeLine();
		for (int i = 0; i < 2; i++) {
			String word = io.readToken();
			BigInteger addend = BigInteger.ZERO;
			for (int j = 0; j < word.length(); j++)
				addend = addend.multiply(BASE).add(BigInteger.valueOf(word.charAt(j) - 'A'));
			sum = sum.add(addend);
		}
		
		String out = "";
		do {
			BigInteger[] quotRem = sum.divideAndRemainder(BASE);
			out = (char)('A' + quotRem[1].intValue()) + out;
			sum = quotRem[0];
		} while (sum.signum() == 1);
		io.println(out);
	}
	
}
