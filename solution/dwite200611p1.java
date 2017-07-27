/* 
 * DWITE programming contest solutions
 * November 2006 - Problem 1: "13375P34|<"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200611p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200611p1().run("DATA11.txt", "OUT11.txt");
	}
	
	
	protected void runOnce() {
		String line = io.readLine();
		for (String[] repl : REPLACEMENTS)
			line = line.replace(repl[0], repl[1]);
		io.println(line);
	}
	
	
	private static final String[][] REPLACEMENTS = {
		{"4"     , "A"},
		{"8"     , "B"},
		{"("     , "C"},
		{"|)"    , "D"},
		{"3"     , "E"},
		{"9"     , "G"},
		{"|-|"   , "H"},
		{"|<"    , "K"},
		{"1"     , "L"},
		{"/\\/\\", "M"},
		{"|\\|"  , "N"},
		{"0"     , "O"},
		{"|2"    , "R"},
		{"5"     , "S"},
		{"7"     , "T"},
		{"\\/\\/", "W"},
		{"><"    , "X"},
		{"'/"    , "Y"},
		// These two are deliberately placed after the others
		{"|"     , "I"},
		{"\\/"   , "V"},
	};
	
}
