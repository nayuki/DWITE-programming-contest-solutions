import org.junit.Test;


public class Dwite200411Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200411p1.class, "DATA11Nov2004.txt", "OUT11Nov2004.txt");
		DwiteTestUtils.test(dwite200411p1.class, "DATA12Nov2004.txt", "OUT12Nov2004.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200411p2.class, "DATA21Nov2004.txt", "OUT21Nov2004.txt");
		DwiteTestUtils.test(dwite200411p2.class, "DATA22Nov2004.txt", "OUT22Nov2004.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200411p3.class, "DATA31Nov2004.txt", "OUT31Nov2004.txt");
		DwiteTestUtils.test(dwite200411p3.class, "DATA32Nov2004.txt", "OUT32Nov2004.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200411p4.class, "DATA41Nov2004.txt", "OUT41Nov2004.txt");
		DwiteTestUtils.test(dwite200411p4.class, "DATA42Nov2004.txt", "OUT42Nov2004.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200411p5.class, "DATA51Nov2004.txt", "OUT51Nov2004.txt");
		DwiteTestUtils.test(dwite200411p5.class, "DATA52Nov2004.txt", "OUT52Nov2004.txt");
	}
	
}
