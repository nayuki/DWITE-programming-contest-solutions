// DWITE - October 2011 - Problem 2: Penny Game
// Solution by Nayuki Minase


public final class dwite201110p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA2.txt", "OUT2.txt", new dwite201110p2());
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		
		int[] stacks = new int[n];
		for (int i = 0; i < n; i++)
			stacks[i] = io.readIntLine();
		
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += stacks[i];
		if (sum % n != 0)
			throw new IllegalArgumentException();
		
		int average = sum / n;
		int diffsum = 0;
		for (int i = 0; i < n; i++)
			diffsum += Math.abs(stacks[i] - average);
		io.println(diffsum / 2);
	}
	
}
