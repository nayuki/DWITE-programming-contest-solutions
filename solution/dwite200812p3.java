/* 
 * DWITE programming contest solutions
 * December 2008 - Problem 3: "Unicorns and Teaspoons"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.HashMap;
import java.util.Map;


public final class dwite200812p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200812p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	private static Map<String,Integer> ouncesByUnit = new HashMap<>();
	
	static {
		ouncesByUnit.put("oz"  ,   1);
		ouncesByUnit.put("gill",   5);
		ouncesByUnit.put("pt"  ,  20);
		ouncesByUnit.put("qt"  ,  40);
		ouncesByUnit.put("gal" , 160);
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int val = io.readIntToken();
		val *= ouncesByUnit.get(io.readToken());
		if (!io.readToken().equals("in"))
			throw new IllegalArgumentException();
		val /= ouncesByUnit.get(io.readToken());
		io.println(val);
	}
	
}
