/* 
 * DWITE programming contest solutions
 * October 2004 - Problem 3: "The Tallest in the Class"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.math.BigDecimal;
import java.util.Arrays;


public final class dwite200410p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200410p3().run("DATA3", "OUT3");
	}
	
	
	protected void run() {
		// Read input
		int n = io.readIntLine();
		Student[] students = new Student[n];
		for (int i = 0; i < n; i++) {
			io.tokenizeLine();
			String name = io.readToken();
			String height = io.readToken();
			String unit = io.readToken();
			students[i] = new Student(name, height, unit);
		}
		
		// Sort by height and write names to output
		Arrays.sort(students);
		for (int i = 0; i < 5 && i < students.length; i++)
			io.println(students[i].name);
	}
	
	
	
	private static final class Student implements Comparable<Student> {
		
		public final String name;
		public final BigDecimal height;  // In millimetres
		
		
		public Student(String name, String height, String unit) {
			this.name = name;
			int scale = switch (unit) {
				case  "m" -> 3;
				case "dm" -> 2;
				case "cm" -> 1;
				case "mm" -> 0;
				default -> throw new AssertionError("Invalid unit");
			};
			this.height = new BigDecimal(height).movePointRight(scale);
		}
		
		
		public int compareTo(Student other) {
			if (other.height.compareTo(height) != 0)
				return other.height.compareTo(height);  // Descending
			else
				return name.compareTo(other.name);  // Ascending
		}
		
	}
	
}
