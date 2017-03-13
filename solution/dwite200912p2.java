/* 
 * DWITE programming contest solutions
 * December 2009 - Problem 2: "Rounding to Fibonacci"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200912p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200912p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		
		int low = 0;
		while (fibonacci(low + 1) <= n)
			low++;
		int high = low + 1;
		
		if (fibonacci(high) - n <= n - fibonacci(low))
			io.println(fibonacci(high));
		else
			io.println(fibonacci(low));
	}
	
	
	private static int fibonacci(int n) {
		int a = 0;
		int b = 1;
		for (int i = 0; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return a;
	}
	
}
