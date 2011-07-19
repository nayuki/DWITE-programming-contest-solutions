// DWITE - October 2010 - Problem 1: Age Gate
// Solution by Nayuki Minase


public final class dwite201010p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA1.txt", "OUT1.txt", new dwite201010p1());
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int d = io.readIntToken();
		int m = io.readIntToken();
		int y = io.readIntToken();
		boolean oldEnough =    y < 1997
		                    || y == 1997 && m < 10
		                    || y == 1997 && m == 10 && d <= 27;
		io.println(oldEnough ? "old enough" : "too young");
	}
}
