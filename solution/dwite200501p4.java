/* 
 * DWITE - January 2005 - Problem 4: Zeller's Congruence
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200501p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200501p4().run("DATA41.txt", "OUT41.txt");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int m = getMonth(io.readToken());
		String daystr = io.readToken();
		int d = Integer.parseInt(daystr.substring(0, daystr.length() - 1));
		int y = io.readIntToken();
		io.println(DAYS_OF_WEEK[getDayOfWeek(y, m, d)]);
	}
	
	
	// Zeller's congruence computation
	private static int getDayOfWeek(int y, int m, int d) {
		if (m <= 2) {
			m += 12;
			y--;
		}
		int c = y / 100;
		y %= 100;
		int dow = (26*(m+1)/10 + d + y + y/4 + c/4 - 2*c) % 7;
		if (dow < 0)
			dow += 7;
		return dow;
	}
	
	
	// Returns the month number corresponding to the string, starting with January = 1.
	private static int getMonth(String s) {
		for (int i = 0; i < MONTHS.length; i++) {
			if (s.equals(MONTHS[i]))
				return i + 1;
		}
		throw new IllegalArgumentException("Invalid month");
	}
	
	
	private static final String[] MONTHS = {
		"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE",
		"JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"
	};
	
	private static final String[] DAYS_OF_WEEK = {
		"SATURDAY", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"
	};
	
}
