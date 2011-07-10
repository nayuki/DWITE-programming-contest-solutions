// DWITE - November 2005 - Problem 3: Cinquain Poetry

import dwite.*;


public final class dwite200511p3 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA31.txt", "OUT31.txt", new dwite200511p3());
	}
	
	
	private static final int[] syllablePattern = {2, 4, 6, 8, 2};
	
	
	protected void runOnce() {
		int worstdev = 0;
		int worstline = -1;
		for (int i = 0; i < 5; i++) {
			int syllables = countSyllables(io.readLine());
			// int syllables = countSyllablesUsingRegex(in.readLine());
			int deviation = syllables - syllablePattern[i];
			if (Math.abs(deviation) > Math.abs(worstdev)) {
				worstdev = deviation;
				worstline = i;
			}
		}
		
		String manyfew;
		if      (worstdev < 0) manyfew = "FEW";
		else if (worstdev > 0) manyfew = "MANY";
		else throw new AssertionError("No mistakes made");
		io.printf("LINE %d - %d SYLLABLE(S) TOO %s%n", worstline + 1, Math.abs(worstdev), manyfew);
	}
	
	
	private static int countSyllables(String s) {
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ' || s.charAt(i) == '-')
				count++;
		}
		return count;
	}
	
	
	@SuppressWarnings("unused")
	private static int countSyllablesUsingRegex(String s) {
		return s.replaceAll("[^ \\-]", "").length() + 1;  // One-liners rock
	}
	
}
