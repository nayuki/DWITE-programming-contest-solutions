import org.junit.Test;


public final class Dwite201004Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201004p1.class, "201004-DATA1.txt", "201004-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201004p2.class, "201004-DATA2.txt", "201004-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201004p3.class, "201004-DATA3.txt", "201004-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201004p4.class, "201004-DATA4.txt", "201004-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201004p5.class, "201004-DATA5.txt", "201004-OUT5.txt");
	}
	
}
