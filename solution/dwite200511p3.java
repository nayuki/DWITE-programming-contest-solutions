/* 
 * DWITE - November 2005 - Problem 3: Cinquain Poetry
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200511p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200511p3().run("DATA31.txt", "OUT31.txt");
	}
	
	
	private static final int[] syllablePattern = {2, 4, 6, 8, 2};
	
	
	protected void runOnce() {
		int worstdev = 0;
		int worstline = -1;
		for (int i = 0; i < 5; i++) {
			int syllables = io.readLine().split("[ -]").length;
			int deviation = syllables - syllablePattern[i];
			if (Math.abs(deviation) > Math.abs(worstdev)) {
				worstdev = deviation;
				worstline = i;
			}
		}
		
		String manyfew;
		if      (worstdev < 0) manyfew = "FEW";
		else if (worstdev > 0) manyfew = "MANY";
		else throw new AssertionError("No mistakes made");
		io.printf("LINE %d - %d SYLLABLE(S) TOO %s%n", worstline + 1, Math.abs(worstdev), manyfew);
	}
	
}
