import org.junit.Test;


public final class Dwite201101Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201101p1.class, "201101-DATA1.txt", "201101-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201101p2.class, "201101-DATA2.txt", "201101-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201101p3.class, "201101-DATA3.txt", "201101-OUT3.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201101p4.class, "201101-DATA4.txt", "201101-OUT4.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201101p5.class, "201101-DATA5.txt", "201101-OUT5.txt");
	}
	
}
