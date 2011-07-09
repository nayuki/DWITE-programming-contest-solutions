import java.math.BigInteger;

import dwite.DwiteIo;


// DWITE - October 2004 - Problem 5: Super Long Sums
public class dwite200410p5 {
	
	public static void main(String[] args) {
		new dwite200410p5(new DwiteIo("DATA5", "OUT5"));
	}
	
	
	public dwite200410p5(DwiteIo io) {
		for (int i = 0; i < 5; i++)
			mainOnce(io);
		io.close();
	}
	
	
	private static void mainOnce(DwiteIo io) {
		String x = io.readLine();
		String y = io.readLine();
		io.println(new BigInteger(x).add(new BigInteger(y)).toString());  // Easy version
		//io.println(add(x, y));  // Hard version
	}
	
	
	@SuppressWarnings("unused")
	private static String add(String x, String y) {  // x and y each must have at least 1 digit
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = 0; i < Math.max(x.length(),y.length()); i++) {
			int sum = carry;
			if (i < x.length()) sum += x.charAt(x.length() - 1 - i) - '0';
			if (i < y.length()) sum += y.charAt(y.length() - 1 - i) - '0';
			sb.insert(0, sum % 10);
			carry = sum / 10;
		}
		if (carry > 0)
			sb.insert(0, carry);
		return sb.toString();
	}
	
}
