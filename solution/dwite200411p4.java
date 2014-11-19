/* 
 * DWITE - November 2004 - Problem 4: For Loops
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayList;
import java.util.List;


public final class dwite200411p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200411p4().run("DATA41.txt", "OUT41.txt");
	}
	
	
	protected void runOnce() {
		// Parse line: "sum = value"
		io.tokenizeLine();
		expectNextTokens("sum", "=");
		int sum = io.readIntToken();
		if (io.canReadToken())
			throw new IllegalArgumentException();
		
		// Parse line: "For i = start To finish"
		io.tokenizeLine();
		expectNextTokens("For", "i", "=");
		int start = io.readIntToken();
		expectNextTokens("To");
		int finish = io.readIntToken();
		if (io.canReadToken())
			throw new IllegalArgumentException();
		
		// Parse line: "sum = formula"
		io.tokenizeLine();
		expectNextTokens("sum", "=");
		Formula formula = new Formula(io);
		if (io.canReadToken())
			throw new IllegalArgumentException();
		
		// Parse line: "Next i"
		io.tokenizeLine();
		expectNextTokens("Next", "i");
		if (io.canReadToken())
			throw new IllegalArgumentException();
		
		// Execute formula
		for (int i = start; i <= finish; i++)
			sum = formula.evaluate(sum, i);
		
		// Write output
		io.println(sum);
	}
	
	
	private void expectNextTokens(String... expectedTokens) {
		for (String expTok : expectedTokens) {
			String actualToken = io.readToken();
			if (!expTok.equals(actualToken))
				throw new AssertionError(String.format("Expected \"%s\", got \"%s\"", expTok, actualToken));
		}
	}
	
	
	
	private static class Formula {
		
		private List<Object> formula;
		
		
		public Formula(DwiteIo io) {
			// Parse formula from token stream
			formula = new ArrayList<Object>();
			while (io.canReadToken()) {
				String tok = io.readToken();
				if (tok.matches("\\d+"))
					formula.add(Integer.parseInt(tok));
				else if (tok.matches("\\(-?\\d+\\)"))
					formula.add(Integer.parseInt(tok.substring(1, tok.length() - 1)));
				else
					formula.add(tok);
			}
		}
		
		
		private int evaluate(int sum, int i) {
			// Make a copy of the formula
			List<Object> formula = new ArrayList<Object>(this.formula);
			
			// Substitute variables
			for (int j = 0; j < formula.size(); j++) {
				Object obj = formula.get(j);
				if (obj.equals("sum"))
					formula.set(j, sum);
				else if (obj.equals("i"))
					formula.set(j, i);
			}
			
			// Scan for multiplication and division
			for (int j = 0; j < formula.size(); j++) {
				Object tok = formula.get(j);
				if (tok.equals("*") || tok.equals("\\")) {
					int x = (Integer)formula.get(j - 1);
					int y = (Integer)formula.get(j + 1);
					int z = tok.equals("*") ? x * y : x / y;
					// Replace (x OP y) with z
					formula.subList(j - 1, j + 2).clear();
					formula.add(j - 1, z);
					j -= 2;
				}
			}
			
			// Scan for addition and subtraction
			for (int j = 0; j < formula.size(); j++) {
				Object tok = formula.get(j);
				if (tok.equals("+") || tok.equals("-")) {
					int x = (Integer)formula.get(j - 1);
					int y = (Integer)formula.get(j + 1);
					int z = tok.equals("+") ? x + y : x - y;
					// Replace (x OP y) with z
					formula.subList(j - 1, j + 2).clear();
					formula.add(j - 1, z);
					j -= 2;
				}
			}
			
			if (formula.size() != 1 || !(formula.get(0) instanceof Integer))
				throw new IllegalArgumentException("Invalid formula");
			else
				return (Integer)formula.get(0);
		}
		
	}
	
}
