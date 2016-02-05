/* 
 * DWITE - December 2008 - Problem 1: ASCII Rhombus
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200812p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200812p1().run("DATA1.txt", "OUT1.txt");
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
