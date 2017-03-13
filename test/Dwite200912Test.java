/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import org.junit.Test;


public final class Dwite200912Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200912p1.class, "200912-DATA1.txt", "200912-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200912p2.class, "200912-DATA2.txt", "200912-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200912p3.class, "200912-DATA3.txt", "200912-OUT3.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200912p4.class, "200912-DATA4.txt", "200912-OUT4.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200912p5.class, "200912-DATA5.txt", "200912-OUT5.txt");
	}
	
}
