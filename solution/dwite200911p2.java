/* 
 * DWITE programming contest solutions
 * November 2009 - Problem 2: "Mini DWITE"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200911p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200911p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	private static final int N = 5;
	
	protected void runOnce() {
		// Read questions and compute reference answers
		int[] answers = new int[N];
		for (int i = 0; i < N; i++) {
			io.tokenizeLine();
			answers[i] = io.readIntToken() + io.readIntToken();
		}
		
		// Read actual answers
		int correct = 0;
		for (int i = 0; i < N; i++) {
			if (io.readIntLine() == answers[i])
				correct++;
		}
		io.println(correct);
	}
	
}
