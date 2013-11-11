/* 
 * DWITE - December 2007 - Problem 4: The Convex Fence Company
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200712p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200712p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		int numRocks = io.readIntLine();
		int dollarsPerMeter = io.readIntLine();
		int[][] rocks = new int[numRocks][2];
		for (int i = 0; i < numRocks; i++) {
			io.tokenizeLine();
			rocks[i][0] = io.readIntToken();
			rocks[i][1] = io.readIntToken();
		}
		
		// Find a starting point with minimum x-coordinate (primary) and y-coordinate (secondary)
		int[] start = rocks[0];
		for (int[] rock : rocks) {
			if (rock[0] < start[0] || rock[0] == start[0] && rock[1] < start[1])
				start = rock;
		}
		
		// Gift-wrapping algorithm (Jarvis march)
		int cost = 0;
		int[] point = start.clone();
		int dirX = 0;
		int dirY = 1;
		do {
			// Find next point in convex hull by minimizing the turning angle
			int bestDirX = 0;
			int bestDirY = 0;
			int bestDistSqr = 0;
			for (int[] rock : rocks) {
				int dx = rock[0] - point[0];
				int dy = rock[1] - point[1];
				int comp = compareDirections(dirX, dirY, dx, dy, bestDirX, bestDirY);
				int distSqr = dx * dx + dy * dy;
				if ((dx != 0 || dy != 0) && (bestDirX == 0 && bestDirY == 0 || comp < 0 || comp == 0 && distSqr > bestDistSqr)) {
					bestDistSqr = distSqr;
					bestDirX = dx;
					bestDirY = dy;
				}
			}
			cost += (int)Math.ceil(Math.sqrt(bestDistSqr)) * dollarsPerMeter;
			point[0] += bestDirX;
			point[1] += bestDirY;
			dirX = bestDirX;
			dirY = bestDirY;
		} while (point[0] != start[0] || point[1] != start[1]);
		io.printf("$%d.00%n", cost);
	}
	
	
	// Returns a negative number if dir0 is less of a clockwise turn from baseDir than dir1 is,
	// a positive number if more, or 0 if the same amount of turning
	private static int compareDirections(int baseDirX, int baseDirY, int dir0X, int dir0Y, int dir1X, int dir1Y) {
		// Voodoo involving dot and cross products
		int rotDirX = -baseDirY;
		int rotDirY = baseDirX;
		int side0 = Integer.signum(dir0X * rotDirX + dir0Y * rotDirY);
		int side1 = Integer.signum(dir1X * rotDirX + dir1Y * rotDirY);
		double dot0 = (dir0X * baseDirX + dir0Y * baseDirY) / Math.hypot(dir0X, dir0Y);
		double dot1 = (dir1X * baseDirX + dir1Y * baseDirY) / Math.hypot(dir1X, dir1Y);
		if (side0 == 0 && dot0 > 0 && side1 == 0 && dot1 > 0)
			return 0;
		else if (side0 == 0 && dot0 > 0)
			return -1;
		else if (side1 == 0 && dot1 > 0)
			return 1;
		else if (side0 == 0 && side1 == 0)
			return 0;
		else if (side0 != side1)
			return side0 - side1;
		else {  // side0 == side1 == {-1 or +1}
			if (dot0 != dot1)
				return side0 * (int)Math.signum(dot0 - dot1);
			else
				return 0;
		}
	}
	
}
