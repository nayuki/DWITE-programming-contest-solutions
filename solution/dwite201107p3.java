/* 
 * DWITE - July 2011 - Problem 3: Triangles in a grid
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public final class dwite201107p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201107p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int a = io.readIntToken();
		int b = io.readIntToken();
		int x = io.readIntToken();
		int y = io.readIntToken();
		
		// Triangles are similar iff they have the same multiset of side lengths
		Set<List<Integer>> triangles = new HashSet<List<Integer>>();
		int[] coordinates = new int[6];
		for (int i = 0; i < coordinates.length; i += 2) {
			coordinates[i + 0] = a;
			coordinates[i + 1] = b;
		}
		while (true) {
			Integer[] sides = {
				distSqr(coordinates[0], coordinates[1], coordinates[2], coordinates[3]),
				distSqr(coordinates[2], coordinates[3], coordinates[4], coordinates[5]),
				distSqr(coordinates[4], coordinates[5], coordinates[0], coordinates[1]),
			};
			Arrays.sort(sides);
			if (!(sides[0] == 0 || sqr(sides[2] - sides[0] - sides[1]) == sides[0] * sides[1] * 4))  // Exclude degenerate triangles
				triangles.add(Arrays.asList(sides));
			
			// Increment coordinates
			int i = coordinates.length - 1;
			while (i >= 0) {
				if (i % 2 == 0 && coordinates[i] == x)
					coordinates[i] = a;
				else if (i % 2 == 1 && coordinates[i] == y)
					coordinates[i] = b;
				else
					break;
				i--;
			}
			if (i < 0)
				break;
			coordinates[i]++;
		}
		io.println(triangles.size());
	}
	
	
	private static int distSqr(int x0, int y0, int x1, int y1) {
		return sqr(x0 - x1) + sqr(y0 - y1);
	}
	
	
	private static int sqr(int x) {
		return x * x;
	}
	
}
