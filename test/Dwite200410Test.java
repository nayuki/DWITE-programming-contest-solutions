/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import org.junit.Test;


public final class Dwite200410Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200410p1.class, "DATA1Oct2004.txt", "OUT1Oct2004.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200410p2.class, "DATA2Oct2004.txt", "OUT2Oct2004.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200410p3.class, "DATA3Oct2004.txt", "OUT3Oct2004.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200410p4.class, "DATA4Oct2004.txt", "OUT4Oct2004.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200410p5.class, "DATA5Oct2004.txt", "OUT5Oct2004.txt");
	}
	
}
