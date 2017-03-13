/* 
 * DWITE programming contest solutions
 * November 2012 - Problem 5: "Car Hoppers"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201211p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201211p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		io.tokenizeLine();
		int cars = io.readIntToken();
		int range = io.readIntToken();
		int[] heights = new int[cars];
		for (int i = 0; i < heights.length; i++)
			heights[i] = io.readIntLine();
		
		// minCover[i] is the minimum number of guards to cover cars 0 to i (inclusive) such that there is a guard on car i
		int[] minCover = new int[cars];
		for (int i = 0; i < cars; i++) {
			// Find the minimum number of guards to cover cars 0 to i-1 (inclusive)
			int min = Integer.MAX_VALUE / 2;
			
			// Try all possible positions for previous guard
			middle:
			for (int j = 1; j <= range * 2 + 1 && i - j >= 0; j++) {
				for (int k = 1; k < j; k++) {
					if (!canSee(heights, i - j, i - k) && !canSee(heights, i, i - k))
						continue middle;
				}
				min = Math.min(minCover[i - j], min);
			}
			
			if (i <= range && canSee(heights, i, 0))
				min = 0;
			minCover[i] = min + 1;
		}
		
		// Find optimal placement of last guard
		int min = minCover[cars - 1];
		for (int j = 1; j <= range && cars - 1 - j >= 0; j++) {
			if (canSee(heights, cars - 1 - j, cars - 1))
				min = Math.min(minCover[cars - 1 - j], min);
		}
		
		io.println(min);
	}
	
	
	private static boolean canSee(int[] heights, int guard, int car) {
		// Recall that the problem says the guard can't see past a taller car
		if (car < guard) {
			for (int i = guard - 1; i > car; i--) {
				if (heights[i] > heights[guard])
					return false;
			}
		} else if (guard < car) {
			for (int i = guard + 1; i < car; i++) {
				if (heights[i] > heights[guard])
					return false;
			}
		}
		return true;
	}
	
}
