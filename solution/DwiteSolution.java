/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public abstract class DwiteSolution {
	
	// The I/O object, presented as a field for convenience.
	protected DwiteIo io;
	
	
	
	// The constructor with nothing to initalize.
	public DwiteSolution() {}
	
	
	
	// Entry point
	public void run(String inFilename, String outFilename) {
		run(new DwiteIo(inFilename, outFilename));
	}
	
	// Entry point
	public void run(DwiteIo io) {
		this.io = io;
		run();
	}
	
	
	/* 
	 * For each DWITE solution, at least one of run() or runOnce() needs to be overridden.
	 * By default, run() calls runOnce() 5 times. But if run() is overridden,
	 * then runOnce() does not necessarily need to be overridden or even used.
	 */
	
	protected void run() {
		for (int i = 0; i < 5; i++)
			runOnce();
	}
	
	
	protected void runOnce() {}
	
}
