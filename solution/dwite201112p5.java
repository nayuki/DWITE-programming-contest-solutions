// DWITE - December 2011 - Problem 5: Tautology
// Solution by Nayuki Minase


public final class dwite201112p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA5.txt", "OUT5.txt", new dwite201112p5());
	}
	
	
	protected void runOnce() {
		for (int i = 0; i < 3; i++) {
			String formula = io.readLine();
			io.print(isTautology(formula) ? "Y" : "N");
		}
		io.println();
	}
	
	
	private static int NUM_ATOMS = 'j' - 'a' + 1;
	
	private static boolean isTautology(String formula) {
		for (int i = 0; i < (1 << NUM_ATOMS); i++) {
			if (!evaluate(assignValues(formula, i)))
				return false;
		}
		return true;
	}
	
	
	private static String assignValues(String formula, int values) {
		for (int i = 0; i < NUM_ATOMS; i++)
			formula = formula.replace((char)('a' + i), (((values >>> i) & 1) == 0) ? 'T' : 'F');
		return formula;
	}
	
	
	private static String[][] RULES = {
		{"~F", "T"},
		{"~T", "F"},
		{"(F ^ F)", "F"},
		{"(F ^ T)", "F"},
		{"(T ^ F)", "F"},
		{"(T ^ T)", "T"},
		{"(F v F)", "F"},
		{"(F v T)", "T"},
		{"(T v F)", "T"},
		{"(T v T)", "T"},
	};
	
	private static boolean evaluate(String formula) {
		boolean changed;
		do {
			changed = false;
			for (String[] rule : RULES) {
				String temp = formula.replace(rule[0], rule[1]);
				if (!temp.equals(formula))
					changed = true;
				formula = temp;
			}
		} while (changed);
		
		if (formula.equals("F"))
			return false;
		else if (formula.equals("T"))
			return true;
		else
			throw new IllegalArgumentException();
	}
	
}
