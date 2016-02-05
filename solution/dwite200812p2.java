/* 
 * DWITE - December 2008 - Problem 2: Wordcount++
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200812p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200812p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		String[] words = io.readLine().split("[^A-Za-z]+");
		int count = 0;
		for (String word : words) {
			if (word.length() > 3)
				count++;
		}
		io.println(count);
	}
	
}
