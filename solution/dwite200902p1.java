/* 
 * DWITE - February 2009 - Problem 1: Baby Diff
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200902p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200902p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		String a = io.readLine();
		String b = io.readLine();
		int i;
		for (i = 0; i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i); i++);
		io.println(i);
	}
	
}
