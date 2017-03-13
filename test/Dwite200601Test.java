/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import org.junit.Test;


public final class Dwite200601Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200601p1.class, "DATA11Jan2006.txt", "OUT11Jan2006.txt");
		DwiteTestUtils.test(dwite200601p1.class, "DATA12Jan2006.txt", "OUT12Jan2006.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200601p2.class, "DATA21Jan2006.txt", "OUT21Jan2006.txt");
		DwiteTestUtils.test(dwite200601p2.class, "DATA22Jan2006.txt", "OUT22Jan2006.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200601p3.class, "DATA31Jan2006.txt", "OUT31Jan2006.txt");
		DwiteTestUtils.test(dwite200601p3.class, "DATA32Jan2006.txt", "OUT32Jan2006.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200601p4.class, "DATA41Jan2006.txt", "OUT41Jan2006.txt");
		DwiteTestUtils.test(dwite200601p4.class, "DATA42Jan2006.txt", "OUT42Jan2006.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200601p5.class, "DATA51Jan2006.txt", "OUT51Jan2006.txt");
		DwiteTestUtils.test(dwite200601p5.class, "DATA52Jan2006.txt", "OUT52Jan2006.txt");
	}
	
}
