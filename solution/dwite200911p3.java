/* 
 * DWITE programming contest solutions
 * November 2009 - Problem 3: "Binary Test String"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200911p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200911p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void runOnce() {
		String pattern = io.readLine();
		for (int i = 0; i < 16; i++) {
			if (!toBinaryString(i, 4).contains(pattern))
				io.println(toBinaryString(i, 4));
		}
	}
	
	
	private static String toBinaryString(int x, int digits) {
		String s = Integer.toString(x, 2);
		while (s.length() < digits)
			s = "0" + s;
		return s;
	}
	
}
