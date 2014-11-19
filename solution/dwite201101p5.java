/* 
 * DWITE - January 2011 - Problem 5: Sleepwalking Probabilities
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201101p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201101p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void runOnce() {
		final int SIZE = 11 * 2 + 1;
		
		io.tokenizeLine();
		int m = io.readIntToken();
		int n = io.readIntToken();
		int s = io.readIntToken();
		int e = io.readIntToken();
		int w = io.readIntToken();
		
		// Dynamic programming
		double[][] prob = new double[SIZE][SIZE];
		prob[SIZE / 2][SIZE / 2] = 1;
		for (int i = 0; i < m; i++) {
			double[][] newProb = new double[SIZE][SIZE];
			for (int y = 1; y < SIZE - 1; y++) {
				for (int x = 1; x < SIZE - 1; x++) {
					newProb[y][x] =   prob[y - 1][x    ] * s / 100.0
					                + prob[y + 1][x    ] * n / 100.0
					                + prob[y    ][x - 1] * e / 100.0
					                + prob[y    ][x + 1] * w / 100.0;
				}
			}
			prob = newProb;
		}
		
		io.println((int)(prob[SIZE / 2][SIZE / 2] * 100));
	}
	
}
