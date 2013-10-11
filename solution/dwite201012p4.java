/* 
 * DWITE - December 2010 - Problem 4: Forest Fires
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201012p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA4.txt", "OUT4.txt", new dwite201012p4());
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
				switch (map[i][j]) {
					case '.':  distance[i][j] = 999;  break;
					case 'T':  distance[i][j] = 999;  break;
					case 'F':  distance[i][j] =   0;  break;
					default:  throw new IllegalArgumentException();
				}
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
