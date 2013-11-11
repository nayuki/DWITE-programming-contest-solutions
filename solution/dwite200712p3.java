/* 
 * DWITE - December 2007 - Problem 3: Playlist
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200712p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200712p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void runOnce() {
		// best[i] represents the maximum total rating achieveable using at most i amount of space
		int capacity = io.readIntLine();
		int[] best = new int[capacity + 1];
		
		int songs = io.readIntLine();
		for (int i = 0; i < songs; i++) {
			io.tokenizeLine();
			io.readToken();  // Discard song title
			int rating = io.readIntToken();
			int size = io.readIntToken();
			for (int j = capacity; j >= size; j--)
				best[j] = Math.max(best[j - size] + rating, best[j]);
		}
		io.println(best[capacity]);
	}
	
}
