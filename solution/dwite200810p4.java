/* 
 * DWITE - October 2008 - Problem 4: What is this Roman Numeral
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200810p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200810p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	private static String[] ROMAN   = {"M" , "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	private static int[]    DECIMAL = {1000, 900 , 500, 400 , 100, 90  , 50 , 40  , 10 , 9   , 5  , 4   , 1  };
	
	protected void runOnce() {
		String line = io.readLine();
		int sum = 0;
		outer:
		while (line.length() > 0) {
			for (int i = 0; i < ROMAN.length; i++) {
				if (line.startsWith(ROMAN[i])) {
					sum += DECIMAL[i];
					line = line.substring(ROMAN[i].length());
					continue outer;
				}
			}
			throw new IllegalArgumentException();
		}
		io.println(sum);
	}
	
}
