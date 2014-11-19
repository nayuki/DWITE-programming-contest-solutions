/* 
 * DWITE - November 2012 - Problem 1: Sugar Rush
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201211p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201211p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int n = io.readIntToken();
		int c = io.readIntToken();
		int time = 0;
		int rushCounter = 0;
		int rate = 1;
		while (n > 0) {
			int mouthful = Math.min(n, rate);
			n -= mouthful;
			rushCounter += mouthful;
			if (rushCounter >= c) {
				rate *= 2;
				rushCounter = 0;
			}
			time++;
		}
		io.println(time);
	}
	
}
