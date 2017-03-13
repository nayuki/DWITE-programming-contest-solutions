/* 
 * DWITE programming contest solutions
 * February 2013 - Problem 5: "Pattern Lock"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201302p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201302p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void runOnce() {
		int length = io.readIntLine();
		int sum = 0;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++)
				sum += explore(x, y, new boolean[3][3], length);
		}
		io.println(sum - 9);  // Exclude 0-length paths
	}
	
	
	private static int explore(int x, int y, boolean[][] visited, int remain) {
		if (visited[y][x])
			throw new IllegalArgumentException();
		else if (remain == 0)
			return 1;
		else {
			int sum = 1;  // Include the path up to now as a result
			visited[y][x] = true;
			for (int nextY = 0; nextY < 3; nextY++) {
				middle:
				for (int nextX = 0; nextX < 3; nextX++) {
					if (visited[nextY][nextX])
						continue;
					int dx = nextX - x;
					int dy = nextY - y;
					int gcd = DwiteAlgorithm.gcd(dx, dy);
					dx /= gcd;
					dy /= gcd;
					
					// Check that intermediate dots (if any) are already visited
					int tempX = x;
					int tempY = y;
					while (tempX != nextX || tempY != nextY) {
						if (!visited[tempY][tempX])
							continue middle;
						tempX += dx;
						tempY += dy;
					}
					sum += explore(nextX, nextY, visited, remain - 1);
				}
			}
			visited[y][x] = false;
			return sum;
		}
	}
	
}
