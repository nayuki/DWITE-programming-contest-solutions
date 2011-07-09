// DWITE - February 2005 - Problem 1: Bretschneider's Formula

import dwite.*;


public final class dwite200502p1 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA11.txt", "OUT11.txt", new dwite200502p1());
	}
	
	
	private static final int[] x = { 1, -1, -2,  2,  2, -2, -3,  1,  3, -1, -4,  3,  4, -4, -4,  4,  2, -4, -2,  1};
	private static final int[] y = { 1,  2, -1, -2,  2,  3, -3, -3,  3,  4, -2, -5,  5,  5, -5, -5,  4,  1, -4, -1};
	
	
	protected void runOnce(Io io) {
		String s = io.readLine();
		int a = s.charAt(0) - 'A';
		int b = s.charAt(1) - 'A';
		int c = s.charAt(2) - 'A';
		int d = s.charAt(3) - 'A';
		long area = Math.round(getArea(a, b, c, d) * 10);
		io.printf("%d.%d%n", area / 10, area % 10);
	}
	
	
	private static double getArea(int A, int B, int C, int D) {
		int temp = distanceSquared(B,C) + distanceSquared(D,A) - distanceSquared(A,B) - distanceSquared(C,D);
		return Math.sqrt(4*distanceSquared(B,D)*distanceSquared(A,C) - temp*temp) / 4;
	}
	
	
	private static int distanceSquared(int A, int B) {
		return magnitudeSquared(x[A] - x[B], y[A] - y[B]);
	}
	
	
	private static int magnitudeSquared(int x, int y) {
		return x * x + y * y;
	}
	
}
