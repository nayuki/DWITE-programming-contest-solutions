/* 
 * DWITE programming contest solutions
 * November 2011 - Problem 3: "Anonymous Shopping"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public final class dwite201111p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201111p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void runOnce() {
		Map<String,Set<String>> personalInfoToDrinks = new HashMap<>();
		io.tokenizeLine();
		int n = io.readIntToken();
		int m = io.readIntToken();
		
		// Read and process store records
		for (int i = 0; i < n; i++) {
			io.tokenizeLine();
			io.readToken();  // Discard store ID
			String personalInfo = io.readToken();
			String drink = io.readToken();
			get(personalInfoToDrinks, personalInfo, new HashSet<String>()).add(drink);
		}
		
		// Read and process school records
		int count = 0;
		for (int i = 0; i < m; i++) {
			io.tokenizeLine();
			io.readToken();  // Discard name
			String personalInfo = io.readToken();
			Set<String> drinks = get(personalInfoToDrinks, personalInfo, new HashSet<>());
			if (drinks.size() == 1)
				count++;
		}
		io.println(count);
	}
	
	
	private static <K,V> V get(Map<K,V> map, K key, V defaultVal) {
		if (!map.containsKey(key))
			map.put(key, defaultVal);
		return map.get(key);
	}
	
}
