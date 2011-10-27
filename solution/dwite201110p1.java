// DWITE - October 2011 - Problem 1: Arab-lish Numbers
// Solution by Nayuki Minase

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class dwite201110p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA1.txt", "OUT1.txt", new dwite201110p1());
	}
	
	
	protected void runOnce() {
		io.println(reverseNumbers(reverse(io.readLine())));
	}
	
	
	private static String reverseNumbers(String s) {
		StringBuilder sb = new StringBuilder();
		Matcher m = Pattern.compile("(?<!\\S)\\d+(?!\\S)").matcher(s);
		int index = 0;
		while (m.find()) {
			sb.append(s, index, m.start());
			sb.append(reverse(m.group()));
			index = m.end();
		}
		sb.append(s, index, s.length());
		return sb.toString();
	}
	
	
	private static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
}
