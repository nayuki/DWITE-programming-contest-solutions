package dwite;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public final class Io {
	
	private BufferedReader input;
	
	private PrintWriter output;
	
	private StringTokenizer tokenizer;
	
	
	
	public Io(String inFile, String outFile) {
		try {
			input = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), "US-ASCII"));
			output = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outFile), "US-ASCII"));
			tokenizer = null;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public Io(BufferedReader input, PrintWriter output) {
		this.input = input;
		this.output = output;
	}
	
	
	
	// Reads
	
	public String readLine() {
		try {
			tokenizer = null;
			return input.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public int readIntLine() {
		return Integer.parseInt(readLine());
	}
	
	
	public double readDoubleLine() {
		return Double.parseDouble(readLine());
	}
	
	
	// Tokenized reads
	
	public void tokenizeLine() {
		tokenizer = new StringTokenizer(readLine(), " ");
	}
	
	
	public boolean canReadToken() {
		return tokenizer.hasMoreTokens();
	}
	
	
	public String readToken() {
		return tokenizer.nextToken();
	}
	
	
	public int readIntToken() {
		return Integer.parseInt(readToken());
	}
	
	
	public double readDoubleToken() {
		return Double.parseDouble(readToken());
	}
	
	
	// Writes
	
	public void print(int x) {
		output.print(x);
	}
	
	public void print(String s) {
		output.print(s);
	}
	
	public void println() {
		output.println();
	}
	
	public void println(int x) {
		output.println(x);
	}
	
	public void println(String s) {
		output.println(s);
	}
	
	
	public void printf(String format, Object... args) {
		output.printf(format, args);
	}
	
	
	// Miscellaneous
	
	public void close() {
		try {
			input.close();
			output.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
