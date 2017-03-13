import org.junit.Test;


public final class Dwite201110Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201110p1.class, "201110-DATA1.txt", "201110-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201110p2.class, "201110-DATA2.txt", "201110-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201110p3.class, "201110-DATA3.txt", "201110-OUT3.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201110p4.class, "201110-DATA4.txt", "201110-OUT4.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201110p5.class, "201110-DATA5.txt", "201110-OUT5.txt");
	}
	
}
