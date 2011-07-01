import org.junit.Test;


public class Dwite200701Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200701p1.class, "DATA11Jan2007.txt", "OUT11Jan2007.txt");
		DwiteTestUtils.test(dwite200701p1.class, "DATA12Jan2007.txt", "OUT12Jan2007.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200701p2.class, "DATA21Jan2007.txt", "OUT21Jan2007.txt");
		DwiteTestUtils.test(dwite200701p2.class, "DATA22Jan2007.txt", "OUT22Jan2007.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200701p3.class, "DATA31Jan2007.txt", "OUT31Jan2007.txt");
		DwiteTestUtils.test(dwite200701p3.class, "DATA32Jan2007.txt", "OUT32Jan2007.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200701p4.class, "DATA41Jan2007.txt", "OUT41Jan2007.txt");
		DwiteTestUtils.test(dwite200701p4.class, "DATA42Jan2007.txt", "OUT42Jan2007.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200701p5.class, "DATA51Jan2007.txt", "OUT51Jan2007.txt");
		DwiteTestUtils.test(dwite200701p5.class, "DATA52Jan2007.txt", "OUT52Jan2007.txt");
	}
	
}