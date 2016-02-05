/* 
 * DWITE - February 2009 - Problem 3: Working Directory
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Stack;


public final class dwite200902p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200902p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	protected void runOnce() {
		Stack<String> curDir = new Stack<String>();
		for (String part : tokenizePath(io.readLine(), true))
			curDir.push(part);
		for (String part : tokenizePath(io.readLine(), false)) {
			if (part.equals("."));
			else if (part.equals("..")) {
				if (!curDir.isEmpty())
					curDir.pop();
			} else
				curDir.push(part);
		}
		for (String part : curDir)
			io.print("/" + part);
		io.println("/");
	}
	
	
	private static String[] tokenizePath(String path, boolean isAbsolute) {
		if (!path.endsWith("/") || path.contains("//"))
			throw new IllegalArgumentException();
		if (isAbsolute) {
			if (!path.startsWith("/"))
				throw new IllegalArgumentException();
			path = path.substring(1);
		}
		
		if (path.equals(""))
			return new String[0];
		else
			return path.substring(0, path.length() - 1).split("/");
	}
	
}
