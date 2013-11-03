import org.junit.Test;


public class Dwite200812Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200812p1.class, "200812-DATA1.txt", "200812-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200812p2.class, "200812-DATA2.txt", "200812-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200812p3.class, "200812-DATA3.txt", "200812-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200812p4.class, "200812-DATA4.txt", "200812-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200812p5.class, "200812-DATA5.txt", "200812-OUT5.txt");
	}
	
}
