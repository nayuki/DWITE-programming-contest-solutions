/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import org.junit.Test;


public final class Dwite200802Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200802p1.class, "200802-DATA1.txt", "200802-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200802p2.class, "200802-DATA2.txt", "200802-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200802p3.class, "200802-DATA3.txt", "200802-OUT3.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200802p4.class, "200802-DATA4.txt", "200802-OUT4.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200802p5.class, "200802-DATA5.txt", "200802-OUT5.txt");
	}
	
}
