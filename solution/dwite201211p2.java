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
		io.tokenizeLine();
		String word = io.readToken();
		BigInteger x = BigInteger.ZERO;
		for (int i = 0; i < word.length(); i++)
			x = x.multiply(BASE).add(BigInteger.valueOf(word.charAt(i) - 'A'));
		
		word = io.readToken();
		BigInteger y = BigInteger.ZERO;
		for (int i = 0; i < word.length(); i++)
			y = y.multiply(BASE).add(BigInteger.valueOf(word.charAt(i) - 'A'));
		
		BigInteger sum = x.add(y);
		String out = "";
		do {
			BigInteger[] temp = sum.divideAndRemainder(BASE);
			out = (char)('A' + temp[1].intValue()) + out;
			sum = temp[0];
		} while (sum.signum() == 1);
		io.println(out);
	}
	
}
