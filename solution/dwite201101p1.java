// DWITE - January 2011 - Problem 1: Future Printer
// Solution by Nayuki Minase


public final class dwite201101p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA1.txt", "OUT1.txt", new dwite201101p1());
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		int width = (n + 1) / 2 * 2 - 1;
		for (int i = 0; i < n; i++) {
			int w = i / 2 * 2 + 1;
			print(".", (width - w) / 2);
			print("*", w);
			print(".", (width - w) / 2);
			io.println();
		}
	}
	
	
	private void print(String s, int n) {
		for (int i = 0; i < n; i++)
			io.print(s);
	}
	
}
