/* 
 * DWITE - February 2013 - Problem 1: Travel Time
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201302p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201302p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		String time = io.readToken();
		int journey = io.readIntToken();
		int timezone = io.readIntToken();
		int arrivalHour = (Integer.parseInt(time.substring(0, 2)) + journey + timezone + 48) % 24;
		io.printf("%02d%s%n", arrivalHour, time.substring(2));
	}
	
}
