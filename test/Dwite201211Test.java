/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import org.junit.Test;


public final class Dwite201211Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201211p1.class, "201211-DATA1.txt", "201211-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201211p2.class, "201211-DATA2.txt", "201211-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201211p3.class, "201211-DATA3.txt", "201211-OUT3.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201211p4.class, "201211-DATA4.txt", "201211-OUT4.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201211p5.class, "201211-DATA5.txt", "201211-OUT5.txt");
	}
	
}
