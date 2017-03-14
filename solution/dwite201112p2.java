/* 
 * DWITE programming contest solutions
 * December 2011 - Problem 2: "Magical Ponds"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public final class dwite201112p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201112p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		List<BigInteger> ponds = new ArrayList<>();
		io.tokenizeLine();
		for (int i = 0; i < n; i++)
			ponds.add(new BigInteger(io.readToken()));
		
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i <= n; i++)
			sum = sum.add(product(ponds.subList(i, n)));
		
		io.println(sum.divide(sum.gcd(product(ponds))).toString());
	}
	
	
	private static BigInteger product(List<BigInteger> list) {
		BigInteger product = BigInteger.ONE;
		for (BigInteger x : list)
			product = product.multiply(x);
		return product;
	}
	
}
