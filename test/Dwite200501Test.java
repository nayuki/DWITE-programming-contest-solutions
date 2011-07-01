import org.junit.Test;


public class Dwite200501Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200501p1.class, "DATA11Jan2005.txt", "OUT11Jan2005.txt");
		DwiteTestUtils.test(dwite200501p1.class, "DATA12Jan2005.txt", "OUT12Jan2005.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200501p2.class, "DATA21Jan2005.txt", "OUT21Jan2005.txt");
		DwiteTestUtils.test(dwite200501p2.class, "DATA22Jan2005.txt", "OUT22Jan2005.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200501p3.class, "DATA31Jan2005.txt", "OUT31Jan2005.txt");
		DwiteTestUtils.test(dwite200501p3.class, "DATA32Jan2005.txt", "OUT32Jan2005.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200501p4.class, "DATA41Jan2005.txt", "OUT41Jan2005.txt");
		DwiteTestUtils.test(dwite200501p4.class, "DATA42Jan2005.txt", "OUT42Jan2005.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200501p5.class, "DATA51Jan2005.txt", "OUT51Jan2005.txt");
		DwiteTestUtils.test(dwite200501p5.class, "DATA52Jan2005.txt", "OUT52Jan2005.txt");
	}
	
}