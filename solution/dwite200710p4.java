/* 
 * DWITE programming contest solutions
 * October 2007 - Problem 4: "Stacks of Blocks"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


public final class dwite200710p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200710p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	protected void run() {
		int height = io.readIntLine();  // Variable H
		int numBlocks = io.readIntLine();  // Variable S
		
		// Solve knapsack problem using dynamic programming
		int[] minBlocks = new int[height + 1];
		Arrays.fill(minBlocks, IMPOSSIBLE);
		minBlocks[0] = 0;
		for (int i = 0; i < numBlocks; i++) {
			int block = io.readIntLine();  // Variable N
			for (int j = height; j >= block; j--)
				minBlocks[j] = Math.min(minBlocks[j - block] + 1, minBlocks[j]);
		}
		io.println(minBlocks[height] != IMPOSSIBLE ? minBlocks[height] : 0);
	}
	
	
	private static final int IMPOSSIBLE = 999999;  // Must be greater than all legal values
	
}
