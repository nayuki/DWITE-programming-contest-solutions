import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;



public final class DwiteTestUtils {
	
	private static final String NEW_LINE = System.getProperty("line.separator");
	
	
	public static void test(Class<?> clazz, String infile, String outfile) throws Exception {
		String expectedOutput = readLines(outfile);
		String actualOutput = run(clazz, infile);
		
		if (!expectedOutput.equals(actualOutput)) {
			System.out.println("Expected output:");
			System.out.println(expectedOutput);
			System.out.println("Actual output:");
			System.out.println(actualOutput);
			fail("Output mismatch in " + clazz.getName());
		}
	}
	
	
	private static String run(Class<?> clazz, String infile) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(infile), "US-ASCII"));
		StringWriter out0 = new StringWriter();
		PrintWriter out = new PrintWriter(out0, true);
		
		((DwiteSolution)clazz.newInstance()).run(new DwiteIo(in, out));
		
		return out0.getBuffer().toString();
	}
	
	
	private static String readLines(String file) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "US-ASCII"));
		
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
	
	
	
	private DwiteTestUtils() {}
	
}
