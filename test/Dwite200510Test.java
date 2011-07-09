import org.junit.Test;


public class Dwite200510Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.newTest(dwite200510p1.class, "DATA11Oct2005.txt", "OUT11Oct2005.txt");
		DwiteTestUtils.newTest(dwite200510p1.class, "DATA12Oct2005.txt", "OUT12Oct2005.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.newTest(dwite200510p2.class, "DATA21Oct2005.txt", "OUT21Oct2005.txt");
		DwiteTestUtils.newTest(dwite200510p2.class, "DATA22Oct2005.txt", "OUT22Oct2005.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.newTest(dwite200510p3.class, "DATA31Oct2005.txt", "OUT31Oct2005.txt");
		DwiteTestUtils.newTest(dwite200510p3.class, "DATA32Oct2005.txt", "OUT32Oct2005.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.newTest(dwite200510p4.class, "DATA41Oct2005.txt", "OUT41Oct2005.txt");
		DwiteTestUtils.newTest(dwite200510p4.class, "DATA42Oct2005.txt", "OUT42Oct2005.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.newTest(dwite200510p5.class, "DATA51Oct2005.txt", "OUT51Oct2005.txt");
		DwiteTestUtils.newTest(dwite200510p5.class, "DATA52Oct2005.txt", "OUT52Oct2005.txt");
	}
	
}
