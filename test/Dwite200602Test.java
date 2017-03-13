import org.junit.Test;


public final class Dwite200602Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200602p1.class, "DATA11Feb2006.txt", "OUT11Feb2006.txt");
		DwiteTestUtils.test(dwite200602p1.class, "DATA12Feb2006.txt", "OUT12Feb2006.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200602p2.class, "DATA21Feb2006.txt", "OUT21Feb2006.txt");
		DwiteTestUtils.test(dwite200602p2.class, "DATA22Feb2006.txt", "OUT22Feb2006.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200602p3.class, "DATA31Feb2006.txt", "OUT31Feb2006.txt");
		DwiteTestUtils.test(dwite200602p3.class, "DATA32Feb2006.txt", "OUT32Feb2006.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200602p4.class, "DATA41Feb2006.txt", "OUT41Feb2006.txt");
		DwiteTestUtils.test(dwite200602p4.class, "DATA42Feb2006.txt", "OUT42Feb2006.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200602p5.class, "DATA51Feb2006.txt", "OUT51Feb2006.txt");
		DwiteTestUtils.test(dwite200602p5.class, "DATA52Feb2006.txt", "OUT52Feb2006.txt");
	}
	
}
