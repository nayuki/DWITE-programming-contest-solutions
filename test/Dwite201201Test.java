import org.junit.Test;


public final class Dwite201201Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201201p1.class, "201201-DATA1.txt", "201201-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201201p2.class, "201201-DATA2.txt", "201201-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201201p3.class, "201201-DATA3.txt", "201201-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201201p4.class, "201201-DATA4.txt", "201201-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201201p5.class, "201201-DATA5.txt", "201201-OUT5.txt");
	}
	
}
