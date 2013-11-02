/* 
 * DWITE - November 2007 - Problem 4: All Is Balanced
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Stack;


public final class dwite200711p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA4.txt", "OUT4.txt", new dwite200711p4());
	}
	
	
	protected void runOnce() {
		String line = io.readLine();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			switch (c) {
				case '(':
				case '[':
				case '{':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != '(') {
						io.println("not balanced");
						return;
					}
					break;
				case ']':
					if (stack.isEmpty() || stack.pop() != '[') {
						io.println("not balanced");
						return;
					}
					break;
				case '}':
					if (stack.isEmpty() || stack.pop() != '{') {
						io.println("not balanced");
						return;
					}
					break;
			}
		}
		if (stack.isEmpty())
			io.println("balanced");
		else
			io.println("not balanced");
	}
	
}
