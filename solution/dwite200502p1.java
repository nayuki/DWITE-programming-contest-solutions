/* 
 * DWITE - February 2005 - Problem 1: Bretschneider's Formula
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200502p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200502p1().run("DATA11.txt", "OUT11.txt");
	}
	
	
	private static final int[][] POINTS = {
		{1,1}, {-1,2}, {-2,-1}, {2,-2},
		{2,2}, {-2,3}, {-3,-3}, {1,-3},
		{3,3}, {-1,4}, {-4,-2}, {3,-5},
		{4,5}, {-4,5}, {-4,-5}, {4,-5},
		{2,4}, {-4,1}, {-2,-4}, {1,-1},
	};
	
	
	protected void runOnce() {
		String s = io.readLine();
		int a = s.charAt(0) - 'A';
		int b = s.charAt(1) - 'A';
		int c = s.charAt(2) - 'A';
		int d = s.charAt(3) - 'A';
		long area = Math.round(getArea(POINTS[a], POINTS[b], POINTS[c], POINTS[d]) * 10);
		io.printf("%d.%d%n", area / 10, area % 10);
	}
	
	
	private static double getArea(int[] a, int[] b, int[] c, int[] d) {
		int temp = distSqr(b, c) + distSqr(d, a) - distSqr(a, b) - distSqr(c, d);
		return Math.sqrt(4 * distSqr(b, d) * distSqr(a, c) - temp * temp) / 4;
	}
	
	
	private static int distSqr(int[] a, int[] b) {
		int dx = a[0] - b[0];
		int dy = a[1] - b[1];
		return dx * dx + dy * dy;
	}
	
}
