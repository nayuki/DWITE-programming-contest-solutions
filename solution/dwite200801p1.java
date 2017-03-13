/* 
 * DWITE programming contest solutions
 * January 2008 - Problem 1: "Curve-shot"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200801p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200801p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		double angle = Math.toRadians(io.readIntToken());
		int speed = io.readIntToken();
		double time = speed * Math.sin(angle) / 9.81 * 2;
		double distance = speed * time * Math.cos(angle);
		io.println(Math.round(distance));
	}
	
}
