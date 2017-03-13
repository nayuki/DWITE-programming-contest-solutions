import org.junit.Test;


public final class Dwite201011Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201011p1.class, "201011-DATA1.txt", "201011-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201011p2.class, "201011-DATA2.txt", "201011-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201011p3.class, "201011-DATA3.txt", "201011-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201011p4.class, "201011-DATA4.txt", "201011-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201011p5.class, "201011-DATA5.txt", "201011-OUT5.txt");
	}
	
}
