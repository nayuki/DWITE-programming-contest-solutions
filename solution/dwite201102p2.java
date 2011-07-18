// DWITE - February 2011 - Problem 2: Safe from Rooks

import dwite.*;

import java.util.HashSet;
import java.util.Set;


public final class dwite201102p2 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA2.txt", "OUT2.txt", new dwite201102p2());
	}
	
	
	protected void runOnce() {
		// Read sizes
		io.tokenizeLine();
		long rows = io.readIntToken();
		long cols = io.readIntToken();
		int rooks = io.readIntToken();
		
		// We only need to keep track of which rows and which columns have rooks
		Set<Integer> rookRows = new HashSet<Integer>();
		Set<Integer> rookCols = new HashSet<Integer>();
		for (int i = 0; i < rooks; i++) {
			io.tokenizeLine();
			rookRows.add(io.readIntToken());
			rookCols.add(io.readIntToken());
		}
		
		// Grid size, minus occupied rows, minus occupied columns, but plus occupied intersections (because they were double minused)
		io.println(  rows * cols
		           - rookRows.size() * cols
		           - rookCols.size() * rows
		           + (long)rookRows.size() * rookCols.size());
	}
	
}
