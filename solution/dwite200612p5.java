/* 
 * DWITE programming contest solutions
 * December 2006 - Problem 5: "Caesar's Cipher"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200612p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200612p5().run("DATA51.txt", "OUT51.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		String ciphertext = io.readLine();
		String someplaintext = io.readLine();
		
		// Derive shift from the leading character, decrypt, and write output
		int shift = (ciphertext.charAt(0) - someplaintext.charAt(0) + 26) % 26;
		io.println(decrypt(ciphertext, shift));
	}
	
	
	private static String encrypt(String s, int shift) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isUppercase(c))
				sb.append((char)((c - 'A' + shift) % 26 + 'A'));
			else
				sb.append(c);
		}
		return sb.toString();
	}
	
	
	private static String decrypt(String s, int shift) {
		return encrypt(s, (26 - shift) % 26);
	}
	
	
	private static boolean isUppercase(char c) {
		return c >= 'A' && c <= 'Z';
	}
	
}
