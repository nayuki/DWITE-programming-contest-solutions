import org.junit.Test;


public class Dwite201010Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201010p1.class, "201010-DATA1.txt", "201010-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201010p2.class, "201010-DATA2.txt", "201010-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201010p3.class, "201010-DATA3.txt", "201010-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201010p4.class, "201010-DATA4.txt", "201010-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201010p5.class, "201010-DATA5.txt", "201010-OUT5.txt");
	}
	
}
