/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


/* 
 * Superclass of all DWITE solution implementations. Provides an I/O object and defines run methods.
 */
public abstract class DwiteSolution {
	
	// The I/O object, presented as a field for convenience.
	protected DwiteIo io;
	
	
	
	// The constructor with nothing to initialize.
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
	
	
	// Each subclass must override either run() or runOnce().
	// If run() is overridden, then runOnce() is ignored.
	// Otherwise runOnce() is overridden, and it will be called 5 times.
	
	protected void run() {
		for (int i = 0; i < 5; i++)
			runOnce();
	}
	
	
	protected void runOnce() {}
	
}
