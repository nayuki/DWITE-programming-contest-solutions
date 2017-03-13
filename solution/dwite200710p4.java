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
	
	
	private static final int INFINITY = Integer.MAX_VALUE - 1;
	
	protected void run() {
		int height = io.readIntLine();
		int numBlocks = io.readIntLine();
		int[] minBlocks = new int[height + 1];
		Arrays.fill(minBlocks, INFINITY);
		minBlocks[0] = 0;
		for (int i = 0; i < numBlocks; i++) {
			int blockHeight = io.readIntLine();
			for (int j = height; j >= blockHeight; j--)
				minBlocks[j] = Math.min(minBlocks[j - blockHeight] + 1, minBlocks[j]);
		}
		if (minBlocks[height] != INFINITY)
			io.println(minBlocks[height]);
		else
			io.println(0);
	}
	
}
