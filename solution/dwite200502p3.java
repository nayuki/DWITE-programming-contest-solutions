/* 
 * DWITE programming contest solutions
 * February 2005 - Problem 3: "Simple Continued Fractions"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200502p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200502p3().run("DATA31.txt", "OUT31.txt");
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		int d = io.readIntLine();
		while (true) {
			io.print(n / d);  // Output whole part
			n %= d;  // Take fractional part
			if (n == 0)
				break;
			int temp = n;  // Reciprocate
			n = d;
			d = temp;
			io.print(",");
		}
		io.println();
	}
	
}
