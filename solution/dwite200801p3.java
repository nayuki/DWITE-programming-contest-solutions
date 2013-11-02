/* 
 * DWITE - January 2008 - Problem 3: Don't follow my links
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200801p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA3.txt", "OUT3.txt", new dwite200801p3());
	}
	
	
	protected void runOnce() {
		String line = io.readLine();
		line = line.substring(line.indexOf("<a"), line.lastIndexOf("</a>") + 4);  // Trim stuff outside of <a ... </a>
		
		// Find existing rel attribute
		int i = line.indexOf("rel=\"");
		if (i == -1) {
			int j = line.indexOf(">");
			line = line.substring(0, j) + " rel=\"nofollow\"" + line.substring(j);
		} else {
			i += 5;
			int j = line.indexOf('"', i);
			String[] tok = line.substring(i, j).split(" ");  // Existing attribute values
			boolean hasNofollow = false;
			for (String s : tok)
				hasNofollow |= s.equals("nofollow");
			if (!hasNofollow)
				line = line.substring(0, j) + (j > i ? " " : "") + "nofollow" + line.substring(j);
		}
		
		io.println(line);
	}
	
}
