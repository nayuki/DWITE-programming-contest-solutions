/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


/* 
 * Library of commonly used algorithms. All functions are pure, and this class has no state and no instances.
 */
public final class DwiteAlgorithm {
	
	// Computes the floor of the square root of x. For example, sqrt(5) = 2.
	public static int sqrt(int x) {
		if (x < 0)
			throw new IllegalArgumentException();
		int y = 0;
		for (int i = 15; i >= 0; i--) {
			y |= 1 << i;
			if (y > 46340 || y * y > x)
				y ^= 1 << i;
		}
		return y;
	}
	
	
	// Computes the greatest common denominator of x and y. For example, gcd(9, 12) = 3, gcd(-5, 0) = 5.
	public static int gcd(int x, int y) {
		if (x == Integer.MIN_VALUE && y == Integer.MIN_VALUE)
			throw new IllegalArgumentException("Answer overflow");
		
		x = Math.abs(x);
		y = Math.abs(y);
		while (y != 0) {
			int z = x % y;
			x = y;
			y = z;
		}
		return Math.abs(x);
	}
	
	
	// Converts the given number string to a new integer array. For example, toDigits("1234") = [1, 2, 3, 4].
	public static int[] toDigits(String str) {
		int[] digits = new int[str.length()];
		for (int i = 0; i < digits.length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9')
				throw new IllegalArgumentException();
			digits[i] = c - '0';
		}
		return digits;
	}
	
	
	// Computes an array of whether each number from 0 to n (inclusive) is prime.
	// For example, sievePrimes(5) = [false, false, true, true, false, true].
	public static boolean[] sievePrimes(int n) {
		boolean[] isPrime = new boolean[n + 1];
		if (n >= 2)
			isPrime[2] = true;
		for (int i = 3; i <= n; i += 2)
			isPrime[i] = true;
		for (int i = 3, end = sqrt(n); i <= end; i += 2) {
			if (isPrime[i]) {
				for (int j = i * 3; j <= n; j += i << 1)
					isPrime[j] = false;
			}
		}
		return isPrime;
	}
	
	
	// Creates a new 2D integer array of the given dimensions with the given initial cell value.
	public static int[][] newIntGrid(int height, int width, int fill) {
		int[][] result = new int[height][width];
		for (int[] row : result)
			Arrays.fill(row, fill);
		return result;
	}
	
	
	// Creates a new 2D character array of the given dimensions with the given initial cell value.
	public static char[][] newCharGrid(int height, int width, char fill) {
		char[][] result = new char[height][width];
		for (int i = 0; i < height; i++)
			Arrays.fill(result[i], fill);
		return result;
	}
	
	
	// List of directional deltas for the Von Neumann neighborhood (4 cells: cardinal directions only).
	public static final int[][] FOUR_DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	// List of directional deltas for the Moore neighborhood (8 cells: cardinal directions and diagonals).
	public static final int[][] EIGHT_DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
	
	
	
	// Not instantiable.
	private DwiteAlgorithm() {}
	
}
