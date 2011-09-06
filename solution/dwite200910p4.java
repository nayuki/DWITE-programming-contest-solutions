// DWITE - October 2009 - Problem 4: My First True Letter
// Solution by Nayuki Minase


public final class dwite200910p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA4.txt", "OUT4.txt", new dwite200910p4());
	}
	
	
	protected void runOnce() {
		int[] hist = new int[26];
		String line = io.readLine();
		for (int i = 0; i < line.length(); i++)
			hist[line.charAt(i) - 'A']++;
		
		for (int i = 0; i < line.length(); i++) {
			if (hist[line.charAt(i) - 'A'] == 1) {
				io.println(line.charAt(i) + "");
				return;
			}
		}
		throw new IllegalArgumentException();
	}
	
}
