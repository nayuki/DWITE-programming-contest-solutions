/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.junit.Assert;


/* 
 * Shared utility functions for DWITE test suites.
 */
public final class DwiteTestUtils {
	
	// Runs the given DWITE solution class on the given input file,
	// and checks the actual output against the given expected output file.
	public static void test(Class<? extends DwiteSolution> clazz, String inFilePath, String outFilePath) throws Exception {
		String expectedOutput = readLines(new File(outFilePath));
		String actualOutput = run(clazz, new File(inFilePath));
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
	private static String run(Class<? extends DwiteSolution> clazz, File input) throws Exception {
		StringWriter out0 = new StringWriter();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(input), StandardCharsets.US_ASCII))) {
			PrintWriter out = new PrintWriter(out0, true);
			clazz.getDeclaredConstructor().newInstance().run(new DwiteIo(in, out));
		}
		return out0.getBuffer().toString();
	}
	
	
	// Reads the text file at the given path, converts all line separators to the
	// native one, adds a trailing line separator if missing, and returns the full text.
	private static String readLines(File input) throws IOException {
		String newline = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		for (String line : Files.readAllLines(input.toPath()))
			sb.append(line).append(newline);
		return sb.toString();
	}
	
	
	
	// Not instantiable.
	private DwiteTestUtils() {}
	
}
