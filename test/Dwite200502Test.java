import org.junit.Test;


public class Dwite200502Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200502p1.class, "DATA11Feb2005.txt", "OUT11Feb2005.txt");
		DwiteTestUtils.test(dwite200502p1.class, "DATA12Feb2005.txt", "OUT12Feb2005.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200502p2.class, "DATA21Feb2005.txt", "OUT21Feb2005.txt");
		DwiteTestUtils.test(dwite200502p2.class, "DATA22Feb2005.txt", "OUT22Feb2005.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200502p3.class, "DATA31Feb2005.txt", "OUT31Feb2005.txt");
		DwiteTestUtils.test(dwite200502p3.class, "DATA32Feb2005.txt", "OUT32Feb2005.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200502p4.class, "DATA41Feb2005.txt", "OUT41Feb2005.txt");
		DwiteTestUtils.test(dwite200502p4.class, "DATA42Feb2005.txt", "OUT42Feb2005.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200502p5.class, "DATA51Feb2005.txt", "OUT51Feb2005.txt");
		DwiteTestUtils.test(dwite200502p5.class, "DATA52Feb2005.txt", "OUT52Feb2005.txt");
	}
	
}