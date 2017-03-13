/* 
 * DWITE programming contest solutions
 * February 2013 - Problem 2: "Copycat SMS"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
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
