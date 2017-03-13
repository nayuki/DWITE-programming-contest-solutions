/* 
 * DWITE programming contest solutions
 * January 2008 - Problem 5: "It all adds up"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.StringTokenizer;


public final class dwite200801p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200801p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void run() {
		String[][] formulas = new String[5][5];  // First index is the letter, second index is the number
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				formulas[i][j] = io.readLine();
		}
		
		int[][] values = new int[5][5];
		for (int i = 0; i < 25; i++) {  // Sufficient iterations to guarantee convergence if no cycles
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					// Evaluate one cell
					String formula = formulas[j][k];
					if (formula.startsWith("=")) {
						StringTokenizer tok = new StringTokenizer(formula.substring(1));
						int val;
						String s = tok.nextToken();
						char c = s.charAt(0);
						if (s.length() == 2 && c >= 'A' && c <= 'E')
							val = values[c - 'A'][s.charAt(1) - '1'];
						else
							val = Integer.parseInt(s);
						while (tok.hasMoreTokens()) {
							String op = tok.nextToken();
							
							int num;
							s = tok.nextToken();
							c = s.charAt(0);
							if (s.length() == 2 && c >= 'A' && c <= 'E')
								num = values[c - 'A'][s.charAt(1) - '1'];
							else
								num = Integer.parseInt(s);
							
							if (op.equals("+"))
								val += num;
							else if (op.equals("-"))
								val -= num;
							else if (op.equals("*"))
								val *= num;
							else
								throw new IllegalArgumentException();
						}
						values[j][k] = val;
						
					} else
						values[j][k] = Integer.parseInt(formula);
				}
			}
		}
		
		for (int[] column : values) {
			for (int cell : column)
				io.println(cell);
		}
	}
	
}
