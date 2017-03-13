import org.junit.Test;


public final class Dwite200712Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200712p1.class, "200712-DATA1.txt", "200712-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200712p2.class, "200712-DATA2.txt", "200712-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200712p3.class, "200712-DATA3.txt", "200712-OUT3.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200712p4.class, "200712-DATA4.txt", "200712-OUT4.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200712p5.class, "200712-DATA5.txt", "200712-OUT5.txt");
	}
	
}
