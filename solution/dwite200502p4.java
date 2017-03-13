/* 
 * DWITE programming contest solutions
 * February 2005 - Problem 4: "Matrix Chain Product"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayList;
import java.util.List;


public final class dwite200502p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200502p4().run("DATA41.txt", "OUT41.txt");
	}
	
	
	protected void runOnce() {
		// Read the input of matrix dimensions
		List<Integer> dimensions = new ArrayList<Integer>();
		io.tokenizeLine();
		while (true) {
			int temp = io.readIntToken();
			if (temp == 0)
				break;
			dimensions.add(temp);
		}
		
		// mincost[i][j] is the minimum cost of multiplying the chain of matrices from i (inclusive) to j (inclusive)
		// Mark everything as uninitialized with -1
		int n = dimensions.size();  // The list of dimensions represents n - 1 matrices
		int[][] minCost = DwiteAlgorithm.newIntGrid(n - 1, n, -1);
		int[][] maxCost = DwiteAlgorithm.newIntGrid(n - 1, n, -1);
		
		// Dynamic programming lies ahead
		
		// The cost for multiplying a single matrix is zero (note that a matrix has 2 dimensions)
		for (int i = 0; i + 1 < n; i++) {
			minCost[i][i + 1] = 0;
			maxCost[i][i + 1] = 0;
		}
		
		// For each number of consecutive matrices
		for (int i = 2; i < n; i++) {
			// For each starting position
			for (int j = 0; j + i < n; j++) {
				int min = Integer.MAX_VALUE;
				int max = 0;
				// For each split position
				for (int k = 1; k < i; k++) {
					int cost = dimensions.get(j) * dimensions.get(j + k) * dimensions.get(j + i);  // The cost of the current operation
					min = Math.min(cost + minCost[j][j + k] + minCost[j + k][j + i], min);
					max = Math.max(cost + maxCost[j][j + k] + maxCost[j + k][j + i], max);
				}
				minCost[j][j + i] = min;
				maxCost[j][j + i] = max;
			}
		}
		
		// Write the output
		io.printf("%d %d%n", minCost[0][n - 1], maxCost[0][n - 1]);
	}
	
}
