/* 
 * DWITE programming contest solutions
 * December 2006 - Problem 1: "Jimmy's Lost His Marbles"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200612p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200612p1().run("DATA11.txt", "OUT11.txt");
	}
	
	
	protected void runOnce() {
		int capacity = io.readIntLine();  // Variable S
		int numBags = io.readIntLine();  // Variable B
		io.tokenizeLine();
		
		// Solve knapsack problem using dynamic programming
		boolean[] possible = new boolean[capacity + 1];
		possible[0] = true;
		int answer = 0;
		for (int i = 0; i < numBags; i++) {
			int marbles = io.readIntToken();  // Variable N_{i+1}
			for (int j = capacity; j >= marbles; j--) {
				if (possible[j - marbles]) {
					possible[j] = true;
					answer = Math.max(j, answer);
				}
			}
		}
		io.println(answer);
	}
	
}
