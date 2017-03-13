import org.junit.Test;


public final class Dwite201112Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201112p1.class, "201112-DATA1.txt", "201112-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201112p2.class, "201112-DATA2.txt", "201112-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201112p3.class, "201112-DATA3.txt", "201112-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201112p4.class, "201112-DATA4.txt", "201112-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201112p5.class, "201112-DATA5.txt", "201112-OUT5.txt");
	}
	
}
