/* 
 * DWITE programming contest solutions
 * February 2009 - Problem 4: "Wiring the Server Room"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public final class dwite200902p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200902p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	private int numPoints;
	private int[][] distances;
	
	
	protected void runOnce() {
		// Read grid
		char[][] grid = new char[10][];
		for (int i = 0; i < grid.length; i++) {
			grid[i] = io.readLine().toCharArray();
			if (grid[i].length != 10)
				throw new IllegalArgumentException();
		}
		
		// Find port points
		List<int[]> points = new ArrayList<>();
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x] == '#')
					points.add(new int[]{x, y});
			}
		}
		
		// Compute pairwise point distances
		numPoints = points.size();
		distances = new int[points.size()][points.size()];
		for (int i = 0; i < distances.length; i++) {
			for (int j = 0; j < distances[i].length; j++)
				distances[i][j] = Math.abs(points.get(i)[0] - points.get(j)[0]) + Math.abs(points.get(i)[1] - points.get(j)[1]);
		}
		
		// Compute minimum-distance tour/cycle
		minimumTour = new int[points.size()][1 << points.size()];
		for (int[] arr : minimumTour)
			Arrays.fill(arr, -1);
		io.println(minimumTour(0, 1));
	}
	
	
	// Solver for travelling salesman problem
	
	// Memoization
	private int[][] minimumTour;
	
	private int minimumTour(int node, int visited) {  // 'visited' is a bit set
		if (minimumTour[node][visited] == -1) {
			int result;
			if (visited == (1 << numPoints) - 1)
				result = distances[node][0];
			else {
				result = Integer.MAX_VALUE;
				for (int i = 0; i < numPoints; i++) {
					if ((visited & (1 << i)) == 0)
						result = Math.min(distances[node][i] + minimumTour(i, visited | (1 << i)), result);
				}
			}
			minimumTour[node][visited] = result;
		}
		return minimumTour[node][visited];
	}
	
}
