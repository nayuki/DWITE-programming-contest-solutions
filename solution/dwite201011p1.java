// DWITE - December 2010 - Problem 1: Pattern Matching
// Solution by Nayuki Minase


public final class dwite201011p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA1.txt", "OUT1.txt", new dwite201011p1());
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		io.println(normalize(io.readToken()).equals(normalize(io.readToken())) ? "same" : "different");
	}
	
	
	private static String normalize(String word) {
		word = word.replaceAll("[bcdfghjklmnpqrstvwxyz]", "C");  // Consonants
		word = word.replaceAll("[aeiou]", "V");  // Vowels
		return word;
	}
	
}
