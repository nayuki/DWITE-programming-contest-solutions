/* 
 * DWITE - November 2008 - Problem 3: My drink is made of cubes
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayList;
import java.util.List;


public final class dwite200811p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200811p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void runOnce() {
		int volume = io.readIntLine();
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 1; i <= volume; i++) {
			if (volume % i == 0)
				factors.add(i);
		}
		
		long min = Integer.MAX_VALUE;
		for (long width : factors) {
			for (long height : factors) {
				long depth = volume / width / height;
				if (width * height * depth == volume)
					min = Math.min((width * height + height * depth + depth * width) * 2, min);
			}
		}
		io.println(min);
	}
	
}
