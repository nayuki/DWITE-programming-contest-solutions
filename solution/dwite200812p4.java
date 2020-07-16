/* 
 * DWITE programming contest solutions
 * December 2008 - Problem 4: "Time for change"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


public final class dwite200812p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200812p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	protected void runOnce() {
		int amount = io.readIntLine();  // Variable m
		int numCoins = io.readIntLine();  // Variable n
		
		// Solve knapsack problem using dynamic programming
		int[] minCoins = new int[amount + 1];
		Arrays.fill(minCoins, IMPOSSIBLE);
		minCoins[0] = 0;
		for (int i = 0; i < numCoins; i++) {
			int coin = io.readIntLine();  // Variable c
			for (int j = coin; j <= amount; j++)
				minCoins[j] = Math.min(minCoins[j - coin] + 1, minCoins[j]);
		}
		if (minCoins[amount] == IMPOSSIBLE)
			throw new AssertionError();
		io.println(minCoins[amount]);
	}
	
	
	private static final int IMPOSSIBLE = 999999;  // Must be greater than all legal values
	
}
