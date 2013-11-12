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
		int c = io.readIntToken();
		int d = io.readIntToken();
		
		// Triangles are similar iff they have the same multiset of side lengths
		Set<List<Integer>> triangles = new HashSet<List<Integer>>();
		for (int x0 = a; x0 <= c; x0++) {
		for (int x1 = a; x1 <= c; x1++) {
		for (int x2 = a; x2 <= c; x2++) {
		for (int y0 = b; y0 <= d; y0++) {
		for (int y1 = b; y1 <= d; y1++) {
		for (int y2 = b; y2 <= d; y2++) {
			Integer[] sides = {
				distSqr(x0, y0, x1, y1),
				distSqr(x1, y1, x2, y2),
				distSqr(x2, y2, x0, y0),
			};
			Arrays.sort(sides);
			if ((x1 - x0) * (y2 - y0) != (x2 - x0) * (y1 - y0))  // Exclude degenerate (zero-area) triangles
				triangles.add(Arrays.asList(sides));
		}}}}}}
		io.println(triangles.size());
	}
	
	
	private static int distSqr(int x0, int y0, int x1, int y1) {
		return sqr(x0 - x1) + sqr(y0 - y1);
	}
	
	
	private static int sqr(int x) {
		return x * x;
	}
	
}
