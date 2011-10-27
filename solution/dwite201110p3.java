// DWITE - October 2011 - Problem 3: Take a Walk
// Solution by Nayuki Minase


public final class dwite201110p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA3.txt", "OUT3.txt", new dwite201110p3());
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		
		double[][] points = new double[n][2];
		for (int i = 0; i < n; i++) {
			io.tokenizeLine();
			points[i][0] = io.readDoubleToken();
			points[i][1] = io.readDoubleToken();
		}
		
		io.tokenizeLine();
		double px = io.readDoubleToken();
		double py = io.readDoubleToken();
		
		double distSqr = Double.POSITIVE_INFINITY;
		for (int i = 0; i < n; i++) {
			distSqr = Math.min(distSqr(points[i][0], points[i][1], px, py), distSqr);
			if (i < n - 1)
				distSqr = Math.min(minDist(points[i][0], points[i][1], points[i+1][0], points[i+1][1], px, py), distSqr);
		}
		io.printf("%.2f%n", Math.sqrt(distSqr));
	}
	
	
	private static double minDist(double x0, double y0, double x1, double y1, double px, double py) {
		if (x0 == x1 && y0 == y1)
			return Double.POSITIVE_INFINITY;
		
		double dotProd = (px - x0) * (x1 - x0) + (py - y0) * (y1 - y0);
		double t = dotProd / distSqr(x0, y0, x1, y1);
		if (0 <= t && t <= 1)
			return distSqr(x0, y0, px, py) - t * dotProd;
		else
			return Double.POSITIVE_INFINITY;
	}
	
	
	private static double distSqr(double x0, double y0, double x1, double y1) {
		return (x0 - x1) * (x0 - x1) + (y0 - y1) * (y0 - y1);
	}
	
}
