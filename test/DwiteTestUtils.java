/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import org.junit.Assert;


/* 
 * Shared utility functions for DWITE test suites.
 */
public final class DwiteTestUtils {
	
	private static final String NEW_LINE = System.getProperty("line.separator");
	
	
	// Runs the given DWITE solution class on the given input file,
	// and checks the actual output against the given expected output file.
	public static void test(Class<? extends DwiteSolution> clazz, String infile, String outfile) throws Exception {
		String expectedOutput = readLines(outfile);
		String actualOutput = run(clazz, infile);
		
		if (!expectedOutput.equals(actualOutput)) {
			System.out.println("Expected output:");
			System.out.println(expectedOutput);
			System.out.println("Actual output:");
			System.out.println(actualOutput);
			Assert.fail("Output mismatch in " + clazz.getName());
		}
	}
	
	
	// Runs the given DWITE solution class on the given input file,
	// and returns the actual program output as a string.
	private static String run(Class<? extends DwiteSolution> clazz, String infile) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(infile), StandardCharsets.US_ASCII));
		StringWriter out0 = new StringWriter();
		PrintWriter out = new PrintWriter(out0, true);
		
		clazz.newInstance().run(new DwiteIo(in, out));
		
		return out0.getBuffer().toString();
	}
	
	
	// Reads the text file at the given path, converts all line separators to the
	// native one, adds a trailing line separator if missing, and returns the full text.
	private static String readLines(String file) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.US_ASCII));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			String line = in.readLine();
			if (line == null)
				break;
			sb.append(line).append(NEW_LINE);
		}
		
		in.close();
		return sb.toString();
	}
	
	
	
	// Not instantiable.
	private DwiteTestUtils() {}
	
}
