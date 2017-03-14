/* 
 * DWITE programming contest solutions
 * November 2012 - Problem 4: "Magic Trick"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayList;
import java.util.List;


public final class dwite201211p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201211p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	protected void runOnce() {
		int numCards = io.readIntLine();
		int[] ranks = new int[numCards];
		io.tokenizeLine();
		for (int i = 0; i < ranks.length; i++)
			ranks[i] = io.readIntToken();
		
		List<Integer> indexes = new ArrayList<>();
		for (int i = ranks.length - 1; i >= 0; i--) {
			int rank = ranks[i];
			if (rank < 0 || rank > indexes.size()) {
				io.println("IMPOSSIBLE");
				return;
			}
			indexes.add(indexes.size() - rank, i);
		}
		
		int[] cards = new int[numCards];
		for (int i = 0; i < indexes.size(); i++)
			cards[indexes.get(i)] = i + 1;
		
		boolean head = true;
		for (int c : cards) {
			if (head)
				head = false;
			else
				io.print(" ");
			io.print(c);
		}
		io.println();
	}
	
}
