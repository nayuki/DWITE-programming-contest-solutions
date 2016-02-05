/* 
 * DWITE - October 2004 - Problem 2: 24 Hour Clock
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200410p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200410p2().run("DATA2", "OUT2");
	}
	
	
	protected void runOnce() {
		String line = io.readLine();
		
		int hour = Integer.parseInt(line.substring(0, 2));
		String ap;
		if      ( 0 <= hour && hour < 12) ap = "AM";
		else if (12 <= hour && hour < 24) ap = "PM";
		else throw new IllegalArgumentException();
		
		// Convert hour from [0, 24) to [1, 12] branchlessly using modular arithmetic magic
		hour = (hour + 11) % 12 + 1;
		
		io.printf("%d%s %s%n", hour, line.substring(2), ap);
	}
	
}
