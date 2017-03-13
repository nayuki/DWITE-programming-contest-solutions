import org.junit.Test;


public final class Dwite201210Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201210p1.class, "201210-DATA1.txt", "201210-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201210p2.class, "201210-DATA2.txt", "201210-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201210p3.class, "201210-DATA3.txt", "201210-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201210p4.class, "201210-DATA4.txt", "201210-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201210p5.class, "201210-DATA5.txt", "201210-OUT5.txt");
	}
	
}
