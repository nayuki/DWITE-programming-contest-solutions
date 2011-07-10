import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dwite.Io;
import dwite.Runner;
import dwite.Solution;


public class DwiteTestUtils {
	
	private static final String NEW_LINE = System.getProperty("line.separator");
	
	
	public static void test(Class<?> clazz, String infile, String outfile) throws Exception {
		String expectedOutput = readLines(outfile);
		String actualOutput = run(clazz, infile);
		
		if (!expectedOutput.equals(actualOutput)) {
			System.out.println("Expected output:");
			System.out.println(expectedOutput);
			System.out.println("Actual output:");
			System.out.println(actualOutput);
			fail("Output mismatch in "+clazz.getName());
		}
		
	}
	
	
	private static String run(Class<?> clazz, String infile) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		InputStream in0 = new FileInputStream(infile);
		Reader in1 = new InputStreamReader(in0, "US-ASCII");
		BufferedReader in = new BufferedReader(in1);
		
		StringWriter out0 = new StringWriter();
		PrintWriter out = new PrintWriter(out0, true);
		
		Method method = clazz.getMethod("main", BufferedReader.class, PrintWriter.class);
		method.invoke(null, in, out);
		
		in.close();
		in1.close();
		in0.close();
		out.close();
		out0.close();
		
		return out0.getBuffer().toString();
	}
	
	
	public static void newTest(Class<?> clazz, String infile, String outfile) throws Exception {
		String expectedOutput = readLines(outfile);
		String actualOutput = newRun(clazz, infile);
		
		if (!expectedOutput.equals(actualOutput)) {
			System.out.println("Expected output:");
			System.out.println(expectedOutput);
			System.out.println("Actual output:");
			System.out.println(actualOutput);
			fail("Output mismatch in " + clazz.getName());
		}
	}
	
	
	private static String newRun(Class<?> clazz, String infile) throws IOException, IllegalAccessException, IllegalArgumentException, InstantiationException {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(infile), "US-ASCII"));
		StringWriter out0 = new StringWriter();
		PrintWriter out = new PrintWriter(out0, true);
		
		Runner.run(new Io(in, out), (Solution)clazz.newInstance());
		
		return out0.getBuffer().toString();
	}
	
	
	private static String readLines(String file) throws IOException {
		InputStream in0 = new FileInputStream(file);
		Reader in1 = new InputStreamReader(in0, "US-ASCII");
		BufferedReader in = new BufferedReader(in1);
		
		StringBuffer sb = new StringBuffer();
		while (true) {
			String line = in.readLine();
			if (line == null)
				break;
			sb.append(line).append(NEW_LINE);
		}
		
		in.close();
		in1.close();
		in0.close();
		
		return sb.toString();
	}
	
	
	private DwiteTestUtils() {}
	
}
