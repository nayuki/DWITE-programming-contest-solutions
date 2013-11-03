/* 
 * DWITE - December 2008 - Problem 1: ASCII Rhombus
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200812p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA1.txt", "OUT1.txt", new dwite200812p1());
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		for (int i = 1; i < n; i += 2) {
			print('.', (n - i) / 2);
			print('#', i);
			print('.', (n - i) / 2);
			io.println();
		}
		for (int i = n; i >= 1; i -= 2) {
			print('.', (n - i) / 2);
			print('#', i);
			print('.', (n - i) / 2);
			io.println();
		}
	}
	
	
	private void print(char c, int n) {
		for (int i = 0; i < n; i++)
			io.print(c + "");
	}
	
}
