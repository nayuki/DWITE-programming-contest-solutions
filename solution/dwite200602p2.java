/* 
 * DWITE programming contest solutions
 * February 2006 - Problem 2: "Floppy Disk 3 1/2-inch High Density"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200602p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200602p2().run("DATA21.txt", "OUT21.txt");
	}
	
	
	private static final int CAPACITY = 1440;
	
	
	protected void runOnce() {
		// Solve knapsack problem using dynamic programming
		boolean[] possible = new boolean[CAPACITY + 1];
		possible[0] = true;
		int n = io.readIntLine();
		for (int i = 0; i < n; i++) {
			int filesize = io.readIntLine();
			for (int j = CAPACITY - filesize; j >= 0; j--)
				possible[j + filesize] |= possible[j];
		}
		
		// Write the largest possible total size
		for (int i = CAPACITY; i >= 0; i--) {
			if (possible[i]) {  // Guaranteed to execute before the loop ends
				io.println(CAPACITY - i);
				break;
			}
		}
	}
	
}
