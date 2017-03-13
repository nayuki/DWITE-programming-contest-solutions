/* 
 * DWITE programming contest solutions
 * October 2008 - Problem 1: "LaNDscAPE ii"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200810p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200810p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	private static final int MAX_HEIGHT = 5;
	
	protected void run() {
		int[] sizes = new int[5];
		for (int i = 0; i < sizes.length; i++)
			sizes[i] = io.readIntLine();
		
		String[] lines = new String[MAX_HEIGHT];
		for (int i = 0; i < lines.length; i++)
			lines[i] = "";
		
		for (int size : sizes) {
			for (int i = 0; i < lines.length; i++) {  // Work from the bottom
				String line = lines[lines.length - 1 - i];
				if (size == 0)
					line += ".";
				else {
					int width = size * 2 - 1;
					int middle = Math.max(width - i * 2, 0);
					int side = (width - middle) / 2;
					line += repeat(".", side) + repeat("x", middle) + (middle > 0 ? "" : ".") + repeat(".", side);
				}
				lines[lines.length - 1 - i] = line;
			}
		}
		
		for (String line : lines)
			io.println(line);
	}
	
	
	private static String repeat(String s, int n) {
		String result = "";
		for (int i = 0; i < n; i++)
			result += s;
		return result;
	}
	
}
