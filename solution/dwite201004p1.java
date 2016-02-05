/* 
 * DWITE - April 2010 - Problem 1: ROT13 Encryption
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201004p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201004p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		char[] line = io.readLine().toCharArray();
		for (int i = 0; i < line.length; i++) {
			char c = line[i];
			if (c >= 'A' && c <= 'Z')
				line[i] = (char)((c - 'A' + 13) % 26 + 'A');
		}
		io.println(new String(line));
	}
	
}
