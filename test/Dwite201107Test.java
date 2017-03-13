/* 
 * DWITE programming contest solutions
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import org.junit.Test;


public final class Dwite201107Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201107p1.class, "201107-DATA1.txt", "201107-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201107p2.class, "201107-DATA2.txt", "201107-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201107p3.class, "201107-DATA3.txt", "201107-OUT3.txt");
	}
	
}
