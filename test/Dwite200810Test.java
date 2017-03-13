import org.junit.Test;


public final class Dwite200810Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200810p1.class, "200810-DATA1.txt", "200810-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200810p2.class, "200810-DATA2.txt", "200810-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200810p3.class, "200810-DATA3.txt", "200810-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200810p4.class, "200810-DATA4.txt", "200810-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200810p5.class, "200810-DATA5.txt", "200810-OUT5.txt");
	}
	
}
