import java.io.*;
import java.util.StringTokenizer;

import dwite.Algorithm;


// DWITE - February 2006 - Problem 5: Prime Palindromes
public class dwite200602p5 {
	
	private static boolean[] isPrime = Algorithm.sievePrimes(1000000);
	
	
	
	public static void main(BufferedReader in, PrintWriter out) throws IOException {
		for (int i = 0; i < 5; i++)
			mainOnce(in, out);
	}
	
	
	private static void mainOnce(BufferedReader in, PrintWriter out) throws IOException {
		// Read input
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end  = Integer.parseInt(st.nextToken());
		
		// Compute
		int palin = 0;
		for (int i = start; i <= end; i++) {
			if (isPrime[i] && isPalindrome(i))
				palin++;
		}
		
		// Write output
		out.println(palin);
	}
	
	
	private static boolean isPalindrome(int x) {
		String s = Integer.toString(x);
		return new StringBuilder(s).reverse().toString().equals(s);
	}
	
	
	
	private static String infile = "DATA51.txt";  // Specify null to use System.in
	private static String outfile = "OUT51.txt";  // Specify null to use System.out
	
	
	public static void main(String[] args) throws IOException {
		InputStream in0;
		if (infile != null) in0 = new FileInputStream(infile);
		else in0 = System.in;
		Reader in1 = new InputStreamReader(in0, "US-ASCII");
		BufferedReader in = new BufferedReader(in1);
		
		OutputStream out0;
		if (outfile != null) out0 = new FileOutputStream(outfile);
		else out0 = System.out;
		Writer out1 = new OutputStreamWriter(out0, "US-ASCII");
		PrintWriter out = new PrintWriter(out1, true);
		
		main(in, out);
		
		in.close();
		in1.close();
		in0.close();
		out.close();
		out1.close();
		out0.close();
	}
	
}