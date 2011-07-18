// DWITE - February 2011 - Problem 3: Balancing Act

import dwite.*;


public final class dwite201102p3 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA3.txt", "OUT3.txt", new dwite201102p3());
	}
	
	
	protected void runOnce() {
		boolean[] feasibleSum = new boolean[30 * 1000 + 1];
		feasibleSum[0] = true;
		
		int n = io.readIntLine();
		int total = 0;
		for (int i = 0; i < n; i++) {
			int weight = io.readIntLine();
			total += weight;
			for (int j = feasibleSum.length - 1 - weight; j >= 0; j--)
				feasibleSum[j + weight] |= feasibleSum[j];
		}
		
		for (int i = total / 2; i >= 0; i--) {
			if (feasibleSum[i]) {  // Guaranteed to execute before the loop ends
				io.println(total - i * 2);
				break;
			}
		}
	}
	
}
