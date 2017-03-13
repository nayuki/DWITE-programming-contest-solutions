/* 
 * DWITE programming contest solutions
 * January 2010 - Problem 4: "Autocomplete"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201001p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201001p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	private static String[] dictionary;
	
	static {
		dictionary = new String[50000];
		for (int i = 0; i < dictionary.length; i++)
			dictionary[i] = Integer.toString(i * digitSum(i) % 99999);
	}
	
	
	protected void runOnce() {
		String nStr = Integer.toString(io.readIntLine());
		int count = 0;
		for (String s : dictionary) {
			if (s.startsWith(nStr))
				count++;
		}
		io.println(count);
	}
	
	
	private static int digitSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
	
}
