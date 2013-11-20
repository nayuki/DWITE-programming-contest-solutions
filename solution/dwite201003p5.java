/* 
 * DWITE - March 2010 - Problem 5: Weak Passwords
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201003p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201003p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void runOnce() {
		int hash = io.readIntLine();
		for (char a = 'A'; a <= 'Z'; a++) {
		for (char b = 'A'; b <= 'Z'; b++) {
		for (char c = 'A'; c <= 'Z'; c++) {
		for (char d = 'A'; d <= 'Z'; d++) {
			int k = a * 1000000 + b * 10000 + c * 100 + d;
			int m = a * 11 + b * 101 + c * 1009 + d * 10007;
			if (k % m == hash) {
				io.println(new String(new char[]{a, b, c, d}));
				return;
			}
		}}}}
		throw new IllegalArgumentException("No match");
	}
	
}
