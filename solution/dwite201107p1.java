/* 
 * DWITE - July 2011 - Problem 1: Root of a string
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201107p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201107p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		String str = io.readLine();
		outer:
		for (int len = 1; len <= str.length(); len++) {
			if (str.length() % len == 0) {
				String root = str.substring(0, len);
				for (int i = 0; i < str.length(); i += len) {
					if (!str.substring(i, i + len).equals(root))
						continue outer;
				}
				io.println(root);
				return;
			}
		}
		throw new AssertionError();
	}
	
}
