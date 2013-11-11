/* 
 * DWITE - November 2007 - Problem 2: Show Me The Money!
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200711p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200711p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void run() {
		int balance = 0;
		outer:
		for (int i = 0; i < 5; i++) {
			String line = io.readLine();
			for (int j = 0; j < line.length(); j++) {
				switch (line.charAt(j)) {
					case '+':
						balance++;
						break;
					case '-':
						balance--;
						if (balance < 0) {
							io.println("OH NOES!");
							balance = 0;
							continue outer;
						}
						break;
					default:
						throw new IllegalArgumentException();
				}
			}
			io.println(balance);
		}
	}
	
}
