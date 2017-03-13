/* 
 * DWITE programming contest solutions
 * October 2008 - Problem 2: "Simple Checksum"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200810p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200810p2().run("DATA2.txt", "OUT2.txt");
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
