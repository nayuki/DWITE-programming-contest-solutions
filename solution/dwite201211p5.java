/* 
 * DWITE - November 2012 - Problem 5: Car Hoppers
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201211p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA5.txt", "OUT5.txt", new dwite201211p5());
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int cars = io.readIntToken();
		int range = io.readIntToken();
		int[] heights = new int[cars];
		for (int i = 0; i < heights.length; i++)
			heights[i] = io.readIntLine();
		
		// minCover[i] is the triple (minimum number of guards, index of last guard, height of last guard) for covering cars 0 to i (inclusive)
		int[][] minCover = new int[cars][3];
		for (int i = 0; i < minCover.length; i++) {
			// Put a guard here
			minCover[i][0] = 1;
			minCover[i][1] = i;
			minCover[i][2] = heights[i];
			int j;
			for (j = 1; j <= range && i - j >= 0 && heights[i - j] <= heights[i]; j++);
			if (i - j >= 0)
				minCover[i][0] += minCover[i - j][0];
			
			// See if the previous solution was better
			if (i > 0 && minCover[i - 1][0] < minCover[i][0] && i - minCover[i - 1][1] <= range && minCover[i - 1][2] >= heights[i])
				minCover[i] = minCover[i - 1].clone();
		}
		io.println(minCover[minCover.length - 1][0]);
	}
	
}
