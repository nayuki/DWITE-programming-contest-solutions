/* 
 * DWITE - December 2007 - Problem 2: There's An Essay In My Code
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class dwite200712p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200712p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	private static final Pattern TEXT_PATTERN = Pattern.compile("'([^']*)'|\"([^\"]*)\"|/\\*(.*?)\\*/|//(.*)");
	
	protected void runOnce() {
		String line = io.readLine();
		Matcher mat = TEXT_PATTERN.matcher(line);
		boolean head = true;
		while (mat.find()) {
			String text = null;
			for (int i = 1; i <= 4; i++) {
				if (mat.group(i) != null)
					text = mat.group(i);
			}
			if (text == null)
				throw new AssertionError();
			if (head)
				head = false;
			else
				io.print(" ");
			io.print(text);
		}
		io.println();
	}
	
}
