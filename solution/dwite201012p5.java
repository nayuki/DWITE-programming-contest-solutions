// DWITE - December 2010 - Problem 5: E-Searching
// Solution by Nayuki Minase

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public final class dwite201012p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA5.txt", "OUT5.txt", new dwite201012p5());
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		List<String> dict = new ArrayList<String>();
		for (int i = 0; i < n; i++)
			dict.add(io.readLine());
		
		for (int i = 0; i < 5; i++)
			runQuery(dict);
	}
	
	
	private void runQuery(List<String> dict) {
		String query = io.readLine();
		query = query.replaceAll("\\*+", "*");  // Replace consecutive stars with a single star
		query = query.replace("?", ".");   // Translate from glob to regex
		query = query.replace("*", ".*");  // Translate from glob to regex
		Pattern queryPatt = Pattern.compile(query);
		
		boolean head = true;
		for (String word : dict) {
			if (queryPatt.matcher(word).matches()) {
				if (head) head = false;
				else io.print(", ");
				io.print(word);
			}
		}
		if (head)
			io.print("NO MATCH");
		io.println();
	}
	
}
