import org.junit.Test;


public class Dwite200901Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200901p1.class, "200901-DATA1.txt", "200901-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200901p2.class, "200901-DATA2.txt", "200901-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200901p3.class, "200901-DATA3.txt", "200901-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200901p4.class, "200901-DATA4.txt", "200901-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200901p5.class, "200901-DATA5.txt", "200901-OUT5.txt");
	}
	
}
