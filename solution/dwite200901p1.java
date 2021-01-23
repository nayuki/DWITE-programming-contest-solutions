/* 
 * DWITE programming contest solutions
 * January 2009 - Problem 1: "Four-player Pong with no players"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200901p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200901p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		int dx = io.readIntLine();
		int dy = io.readIntLine();
		int x = 50;
		int y = 25;
		while (x > 0 && x < 100 && y > 0 && y < 50) {
			x += dx;
			y += dy;
		}
		io.printf("%d,%d%n", x, y);
	}
	
}
