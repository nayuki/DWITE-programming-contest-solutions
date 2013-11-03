import org.junit.Test;


public class Dwite200811Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200811p1.class, "200811-DATA1.txt", "200811-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200811p2.class, "200811-DATA2.txt", "200811-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200811p3.class, "200811-DATA3.txt", "200811-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200811p4.class, "200811-DATA4.txt", "200811-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200811p5.class, "200811-DATA5.txt", "200811-OUT5.txt");
	}
	
}
