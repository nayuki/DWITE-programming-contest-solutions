// DWITE - October 2006 - Problem 5: Bad Input II

import dwite.*;

import java.math.BigInteger;


public final class dwite200610p5 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA51.txt", "OUT51.txt", new dwite200610p5());
	}
	
	
	protected void runOnce() {
		// Read input
		String a = io.readLine();
		String b = io.readLine();
		
		// Process and compute
		a = sanitizeUsingRegex(a);
		b = sanitizeUsingRegex(b);
		BigInteger x = new BigInteger(a);
		BigInteger y = new BigInteger(b);
		BigInteger z = x.add(y);
		
		// Write output
		io.println(z.toString());
	}
	
	
	@SuppressWarnings("unused")
	private static String sanitize(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isDigit(c))
				sb.append(c);
		}
		return sb.toString();
	}
	
	
	private static String sanitizeUsingRegex(String s) {
		return s.replaceAll("[^0-9]", "");
	}
	
	
	private static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
}
