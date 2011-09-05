import org.junit.Test;


public class Dwite201006Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite201006p1.class, "201006-DATA1.txt", "201006-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite201006p2.class, "201006-DATA2.txt", "201006-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite201006p3.class, "201006-DATA3.txt", "201006-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite201006p4.class, "201006-DATA4.txt", "201006-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite201006p5.class, "201006-DATA5.txt", "201006-OUT5.txt");
	}
	
}
