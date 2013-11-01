/* 
 * DWITE - October 2007 - Problem 3: Where's my QWERTY?
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200710p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		DwiteRunner.run("DATA3.txt", "OUT3.txt", new dwite200710p3());
	}
	
	
	private static final String DVORAK = "[]',.pyfgcrl/=aoeuidhtns-;qjkxbmwvz{}\"<>PYFGCRL?+AOEUIDHTNS_:QJKXBMWVZ";
	private static final String QWERTY = "-=qwertyuiop[]asdfghjkl;'zxcvbnm,./_+QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?";
	
	
	public void run() {
		String str = io.readLine();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int index = DVORAK.indexOf(c);
			if (index != -1)
				io.print(QWERTY.charAt(index) + "");
			else
				io.print(c + "");
		}
		io.println();
	}
	
}
