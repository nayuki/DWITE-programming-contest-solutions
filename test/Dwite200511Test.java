import org.junit.Test;


public final class Dwite200511Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200511p1.class, "DATA11Nov2005.txt", "OUT11Nov2005.txt");
		DwiteTestUtils.test(dwite200511p1.class, "DATA12Nov2005.txt", "OUT12Nov2005.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200511p2.class, "DATA21Nov2005.txt", "OUT21Nov2005.txt");
		DwiteTestUtils.test(dwite200511p2.class, "DATA22Nov2005.txt", "OUT22Nov2005.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200511p3.class, "DATA31Nov2005.txt", "OUT31Nov2005.txt");
		DwiteTestUtils.test(dwite200511p3.class, "DATA32Nov2005.txt", "OUT32Nov2005.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200511p4.class, "DATA41Nov2005.txt", "OUT41Nov2005.txt");
		DwiteTestUtils.test(dwite200511p4.class, "DATA42Nov2005.txt", "OUT42Nov2005.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200511p5.class, "DATA51Nov2005.txt", "OUT51Nov2005.txt");
		DwiteTestUtils.test(dwite200511p5.class, "DATA52Nov2005.txt", "OUT52Nov2005.txt");
	}
	
}
