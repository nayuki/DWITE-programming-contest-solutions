import org.junit.Test;


public class Dwite200902Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200902p1.class, "200902-DATA1.txt", "200902-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200902p2.class, "200902-DATA2.txt", "200902-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200902p3.class, "200902-DATA3.txt", "200902-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200902p4.class, "200902-DATA4.txt", "200902-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200902p5.class, "200902-DATA5.txt", "200902-OUT5.txt");
	}
	
}
