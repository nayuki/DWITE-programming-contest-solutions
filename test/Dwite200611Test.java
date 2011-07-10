import org.junit.Test;


public class Dwite200611Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.newTest(dwite200611p1.class, "DATA11Nov2006.txt", "OUT11Nov2006.txt");
		DwiteTestUtils.newTest(dwite200611p1.class, "DATA12Nov2006.txt", "OUT12Nov2006.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.newTest(dwite200611p2.class, "DATA21Nov2006.txt", "OUT21Nov2006.txt");
		DwiteTestUtils.newTest(dwite200611p2.class, "DATA22Nov2006.txt", "OUT22Nov2006.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.newTest(dwite200611p3.class, "DATA31Nov2006.txt", "OUT31Nov2006.txt");
		DwiteTestUtils.newTest(dwite200611p3.class, "DATA32Nov2006.txt", "OUT32Nov2006.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.newTest(dwite200611p4.class, "DATA41Nov2006.txt", "OUT41Nov2006.txt");
		DwiteTestUtils.newTest(dwite200611p4.class, "DATA42Nov2006.txt", "OUT42Nov2006.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.newTest(dwite200611p5.class, "DATA51Nov2006.txt", "OUT51Nov2006.txt");
		DwiteTestUtils.newTest(dwite200611p5.class, "DATA52Nov2006.txt", "OUT52Nov2006.txt");
	}
	
}
