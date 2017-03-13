/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import org.junit.Test;


public final class Dwite201003Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201003p1.class, "201003-DATA1.txt", "201003-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201003p2.class, "201003-DATA2.txt", "201003-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201003p3.class, "201003-DATA3.txt", "201003-OUT3.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201003p4.class, "201003-DATA4.txt", "201003-OUT4.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201003p5.class, "201003-DATA5.txt", "201003-OUT5.txt");
	}
	
}
