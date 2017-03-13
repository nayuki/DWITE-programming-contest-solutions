/* 
 * DWITE programming contest solutions
 * November 2004 - Problem 3: "Factoring"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class dwite200411p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200411p3().run("DATA31.txt", "OUT31.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		Polynomial poly = new Polynomial(io);
		
		// Find factors
		ArrayList<Integer> output = new ArrayList<Integer>();
		int a0 = poly.getCoefficient(poly.getDegree());
		while (true) {
			int[] root = findRoot(poly);
			if (root == null)
				break;
			output.add(a0 / root[0] * root[1]);
			poly = poly.divide(root[0], root[1]);
		}
		
		// Sort ascending and write output
		Collections.sort(output);
		boolean head = true;
		for (int i : output) {
			if (head)
				head = false;
			else
				io.print(" ");
			io.print(i);
		}
		io.println();
	}
	
	
	private static int[] findRoot(Polynomial poly) {
		int p = Math.abs(poly.getCoefficient(0));
		int q = Math.abs(poly.getCoefficient(poly.getDegree()));
		for (int i = 1; i <= p; i++) {  // Find factors of p
			if (p % i == 0) {
				for (int j = 1; j <= q; j++) {  // Find factors of q
					if (q % j == 0) {
						if (poly.hasRootAt( j, i)) return new int[]{ j, i};
						if (poly.hasRootAt(-j, i)) return new int[]{-j, i};
					}
				}
			}
		}
		return null;
	}
	
	
	
	private static final class Polynomial {
		
		private final List<Integer> coefficients;  // From degree 0 upward
		
		
		
		private Polynomial(List<Integer> coefs) {
			coefficients = coefs;
		}
		
		
		public Polynomial(DwiteIo io) {
			io.tokenizeLine();
			int degree = io.readIntToken();
			coefficients = new ArrayList<Integer>();
			for (int i = 0; i < degree + 1; i++)
				coefficients.add(io.readIntToken());
			Collections.reverse(coefficients);
		}
		
		
		
		public int getDegree() {
			return coefficients.size() - 1;
		}
		
		
		// Returns the coefficient of the monomial with the specified power, x^i.
		public int getCoefficient(int i) {
			return coefficients.get(i);
		}
		
		
		public boolean hasRootAt(int c, int d) {
			return divide(c, d) != null;
		}
		
		
		// Returns a new polynomial representing this polynomial divided by (cx - d), or null if it's not divisible.
		public Polynomial divide(int c, int d) {
			List<Integer> coefs = new ArrayList<Integer>();
			int remainder = 0;
			for (int i = getDegree(); i >= 1; i--) {
				remainder += getCoefficient(i);
				if (remainder % c != 0)
					return null;
				int quotient = remainder / c;
				coefs.add(quotient);
				remainder = quotient * d;
			}
			
			if (remainder == -getCoefficient(0)) {
				Collections.reverse(coefs);
				return new Polynomial(coefs);
			} else
				return null;
		}
		
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			boolean head = true;
			for (int i = getDegree(); i >= 0; i--) {
				if (head) {
					if (getCoefficient(i) < 0)
						sb.append("-");
					head = false;
				} else {
					if (getCoefficient(i) >= 0)
						sb.append(" + ");
					else
						sb.append(" - ");
				}
				sb.append(Math.abs(getCoefficient(i))).append(" x^").append(i);
			}
			return sb.toString();
		}
		
	}
	
}
