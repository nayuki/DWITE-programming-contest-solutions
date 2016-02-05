/* 
 * DWITE - January 2010 - Problem 2: Verifying Distributed Work
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201001p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201001p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		
		int[] hist = new int[101];
		for (int i = 0; i < n; i++)
			hist[io.readIntLine()]++;
		
		int max = hist[0];
		for (int x : hist)
			max = Math.max(x, max);
		
		if (max * 2 > n)  // Majority
			io.println("verified");
		else {
			int maxOccur = 0;
			for (int x : hist) {
				if (x == max)
					maxOccur++;
			}
			if (maxOccur == 1)  // Dominant answer
				io.println("unverified");
			else  // maxOccur > 1
				io.println("unknown");
		}
	}
	
}
