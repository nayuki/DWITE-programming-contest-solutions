/* 
 * DWITE - February 2013 - Problem 2: Copycat SMS
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201302p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201302p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		String s = io.readLine();
		for (int i = 1; i <= s.length(); i++) {
			if (s.substring(i).equals(s.substring(0, s.length() - i))) {
				io.println(s.substring(0, i) + s);
				break;
			}
		}
	}
	
}
