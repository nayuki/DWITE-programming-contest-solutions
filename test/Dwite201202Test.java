import org.junit.Test;


public final class Dwite201202Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201202p1.class, "201202-DATA1.txt", "201202-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201202p2.class, "201202-DATA2.txt", "201202-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201202p3.class, "201202-DATA3.txt", "201202-OUT3.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201202p4.class, "201202-DATA4.txt", "201202-OUT4.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201202p5.class, "201202-DATA5.txt", "201202-OUT5.txt");
	}
	
}
