/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import org.junit.Test;


public final class Dwite200610Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200610p1.class, "DATA11Oct2006.txt", "OUT11Oct2006.txt");
		DwiteTestUtils.test(dwite200610p1.class, "DATA12Oct2006.txt", "OUT12Oct2006.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200610p2.class, "DATA21Oct2006.txt", "OUT21Oct2006.txt");
		DwiteTestUtils.test(dwite200610p2.class, "DATA22Oct2006.txt", "OUT22Oct2006.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200610p3.class, "DATA31Oct2006.txt", "OUT31Oct2006.txt");
		DwiteTestUtils.test(dwite200610p3.class, "DATA32Oct2006.txt", "OUT32Oct2006.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200610p4.class, "DATA41Oct2006.txt", "OUT41Oct2006.txt");
		DwiteTestUtils.test(dwite200610p4.class, "DATA42Oct2006.txt", "OUT42Oct2006.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200610p5.class, "DATA51Oct2006.txt", "OUT51Oct2006.txt");
		DwiteTestUtils.test(dwite200610p5.class, "DATA52Oct2006.txt", "OUT52Oct2006.txt");
	}
	
}
