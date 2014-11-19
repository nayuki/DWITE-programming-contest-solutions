/* 
 * DWITE - October 2004 - Problem 4: CD-ROM Files
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200410p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200410p4().run("DATA4", "OUT4");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int capacity = io.readIntToken();  // Variable A
		int files    = io.readIntToken();  // Variable n
		
		// Solve knapsack problem using dynamic programming
		boolean[] possible = new boolean[capacity + 1];
		possible[0] = true;
		int maxpossible = 0;
		for (int i = 0; i < files; i++) {
			int filesize = io.readIntToken();  // Variable s_{i+1}
			for (int j = capacity - filesize; j >= 0; j--) {
				if (possible[j]) {
					possible[j + filesize] = true;
					maxpossible = Math.max(j + filesize, maxpossible);
				}
			}
		}
		io.println(maxpossible);
	}
	
}
