/* 
 * DWITE programming contest solutions
 * October 2004 - Problem 4: "CD-ROM Files"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200410p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200410p4().run("DATA4", "OUT4");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int capacity = io.readIntToken();  // Variable A
		int numFiles = io.readIntToken();  // Variable n
		
		// Solve knapsack problem using dynamic programming
		boolean[] possible = new boolean[capacity + 1];
		possible[0] = true;
		int answer = 0;
		for (int i = 0; i < numFiles; i++) {
			int fileSize = io.readIntToken();  // Variable s_{i+1}
			for (int j = capacity; j >= fileSize; j--) {
				if (possible[j - fileSize]) {
					possible[j] = true;
					answer = Math.max(j, answer);
				}
			}
		}
		io.println(answer);
	}
	
}
