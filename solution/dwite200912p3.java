/* 
 * DWITE programming contest solutions
 * December 2009 - Problem 3: "Binary Test Strings 2"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200912p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200912p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void runOnce() {
		String pattern = io.readLine();
		int sum = 0;
		for (int i = 0; i < 256; i++) {
			if (toBinaryString(i, 8).indexOf(pattern) == -1)
				sum += Integer.bitCount(i);
		}
		io.println(sum);
	}
	
	
	private static String toBinaryString(int x, int digits) {
		String s = Integer.toString(x, 2);
		while (s.length() < digits)
			s = "0" + s;
		return s;
	}
	
}
