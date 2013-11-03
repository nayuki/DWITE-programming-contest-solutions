/* 
 * DWITE - October 2008 - Problem 2: Simple Checksum
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200810p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA2.txt", "OUT2.txt", new dwite200810p2());
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int num = io.readIntToken();
		if (io.readToken().equals(checksum(num)))
			io.println("match");
		else
			io.println("error");
	}
	
	
	private static String checksum(int n) {
		while (n >= 10) {
			int sum = 0;
			while (n > 0) {
				sum += n % 10;
				n /= 10;
			}
			n = sum;
		}
		return (char)('A' + n - 1) + "";
	}
	
}
