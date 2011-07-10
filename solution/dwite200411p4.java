// DWITE - November 2004 - Problem 4: For Loops

import dwite.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public final class dwite200411p4 extends Solution {
	
	public static void main(String[] args) {
		Runner.run("DATA41.txt", "OUT41.txt", new dwite200411p4());
	}
	
	
	protected void runOnce() {
		// Parse input
		io.tokenizeLine();  // "sum = value"
		expectNextToken(io, "sum");
		expectNextToken(io, "=");
		int sum = io.readIntToken();
		
		io.tokenizeLine();  // "For i = start To finish"
		expectNextToken(io, "For");
		expectNextToken(io, "i");
		expectNextToken(io, "=");
		int start = io.readIntToken();
		expectNextToken(io, "To");
		int finish = io.readIntToken();
		
		io.tokenizeLine();  // "sum = formula"
		expectNextToken(io, "sum");
		expectNextToken(io, "=");
		List<String> formula = new ArrayList<String>();
		while (io.canReadToken())
			formula.add(io.readToken());
		
		io.tokenizeLine();  // "Next i"
		expectNextToken(io, "Next");
		expectNextToken(io, "i");
		
		// Execute formula
		for (int i = start; i <= finish; i++)
			sum = executeOnce(sum, i, formula);
		
		// Write output
		io.println(sum);
	}
	
	
	private static int executeOnce(int sum, int i, List<String> formula) {
		// Dijkstra's shunting yard algorithm
		Stack<Integer> operands = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		for (String token : formula) {
			if (isOperator(token)) {
				// Operators
				while (!operators.empty() && canEvaluate(operators.peek(), token.charAt(0))) {
					int y = operands.pop();
					int x = operands.pop();
					operands.push(evaluate(x, y, operators.pop()));
				}
				operators.push(token.charAt(0));
			} else {
				// Values
				int value;
				if (token.equals("sum"))
					value = sum;
				else if (token.equals("i"))
					value = i;
				else if (token.charAt(0) == '(')
					value = Integer.parseInt(token.substring(1, token.length() - 1));
				else
					value = Integer.parseInt(token);
				operands.push(value);
			}
		}
		while (!operators.empty()) {
			int y = operands.pop();
			int x = operands.pop();
			operands.push(evaluate(x, y, operators.pop()));
		}
		
		if (operands.size() != 1)
			throw new AssertionError();
		return operands.pop();
	}
	
	
	// Returns true if opA has higher precedence than opB.
	private static boolean canEvaluate(char opA, char opB) {
		if (opB == '+' || opB == '-')
			return opA == '+' || opA == '-' || opA == '*' || opA == '\\';
		else if (opB == '*' || opB == '\\')
			return opA == '*' || opA == '\\';
		else
			throw new AssertionError("Invalid operator");
	}
	
	
	private static int evaluate(int x, int y, char op) {
		switch (op) {
			case '+' : return x + y;
			case '-' : return x - y;
			case '*' : return x * y;
			case '\\': return x / y;
			default: throw new AssertionError("Invalid operator");
		}
	}
	
	
	private static boolean isOperator(String s) {
		return s.equals("+")
		    || s.equals("-")
		    || s.equals("*")
		    || s.equals("\\");
	}
	
	
	private static void expectNextToken(Io io, String expectedToken) {
		String actualToken = io.readToken();
		if (!expectedToken.equals(actualToken))
			throw new AssertionError(String.format("Expected \"%s\", got \"%s\"", expectedToken, actualToken));
	}
	
}
