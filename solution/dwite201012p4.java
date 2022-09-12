/* 
 * DWITE programming contest solutions
 * December 2010 - Problem 4: "Forest Fires"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201012p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201012p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	protected void runOnce() {
		final int WIDTH = 10;
		final int HEIGHT = 10;
		
		// Read map and pad
		char[][] map = DwiteAlgorithm.newCharGrid(HEIGHT + 2, WIDTH + 2, '.');
		for (int i = 0; i < HEIGHT; i++) {
			String line = io.readLine();
			for (int j = 0; j < WIDTH; j++)
				map[i + 1][j + 1] = line.charAt(j);
		}
		io.readLine();  // Discard line of hyphens
		
		// Initialize distances
		int[][] distance = new int[HEIGHT + 2][WIDTH + 2];
		for (int i = 0; i < HEIGHT + 2; i++) {
			for (int j = 0; j < WIDTH + 2; j++) {
				distance[i][j] = switch (map[i][j]) {
					case '.' -> 999;
					case 'T' -> 999;
					case 'F' ->   0;
					default -> throw new IllegalArgumentException();
				};
			}
		}
		
		// Compute all minimum distances (Bellman-Ford)
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				for (int k = 0; k < WIDTH; k++) {
					if (map[j + 1][k + 1] == 'T') {
						int d = distance[j + 1][k + 1];
						d = Math.min(distance[j + 1][k + 0] + 1, d);
						d = Math.min(distance[j + 1][k + 2] + 1, d);
						d = Math.min(distance[j + 0][k + 1] + 1, d);
						d = Math.min(distance[j + 2][k + 1] + 1, d);
						distance[j + 1][k + 1] = d;
					}
				}
			}
		}
		
		// Find maximum distance
		int max = 0;
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (map[i + 1][j + 1] == 'T')
					max = Math.max(distance[i + 1][j + 1], max);
			}
		}
		if (max != 999)
			io.println(max);
		else
			io.println(-1);
	}
	
}
