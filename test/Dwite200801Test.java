import org.junit.Test;


public final class Dwite200801Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200801p1.class, "200801-DATA1.txt", "200801-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200801p2.class, "200801-DATA2.txt", "200801-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200801p3.class, "200801-DATA3.txt", "200801-OUT3.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200801p4.class, "200801-DATA4.txt", "200801-OUT4.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200801p5.class, "200801-DATA5.txt", "200801-OUT5.txt");
	}
	
}
