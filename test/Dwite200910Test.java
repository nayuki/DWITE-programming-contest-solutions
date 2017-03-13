import org.junit.Test;


public final class Dwite200910Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200910p1.class, "200910-DATA1.txt", "200910-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200910p2.class, "200910-DATA2.txt", "200910-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200910p3.class, "200910-DATA3.txt", "200910-OUT3.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200910p4.class, "200910-DATA4.txt", "200910-OUT4.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200910p5.class, "200910-DATA5.txt", "200910-OUT5.txt");
	}
	
}
