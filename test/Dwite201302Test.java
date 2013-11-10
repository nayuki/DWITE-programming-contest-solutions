import org.junit.Test;


public class Dwite201302Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201302p1.class, "201302-DATA1.txt", "201302-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201302p2.class, "201302-DATA2.txt", "201302-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201302p3.class, "201302-DATA3.txt", "201302-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201302p4.class, "201302-DATA4.txt", "201302-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201302p5.class, "201302-DATA5.txt", "201302-OUT5.txt");
	}
	
}
