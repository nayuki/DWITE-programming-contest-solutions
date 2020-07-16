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
		int numFiles = io.readIntLine();  // Variable N
		
		// Solve knapsack problem using dynamic programming
		boolean[] possible = new boolean[CAPACITY + 1];
		possible[0] = true;
		int answer = CAPACITY;
		for (int i = 0; i < numFiles; i++) {
			int fileSize = io.readIntLine();  // Variable S
			for (int j = CAPACITY; j >= fileSize; j--) {
				if (possible[j - fileSize]) {
					possible[j] = true;
					answer = Math.min(CAPACITY - j, answer);
				}
			}
		}
		io.println(answer);
	}
	
}
