import org.junit.Test;


public final class Dwite200512Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200512p1.class, "DATA11Dec2005.txt", "OUT11Dec2005.txt");
		DwiteTestUtils.test(dwite200512p1.class, "DATA12Dec2005.txt", "OUT12Dec2005.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200512p2.class, "DATA21Dec2005.txt", "OUT21Dec2005.txt");
		DwiteTestUtils.test(dwite200512p2.class, "DATA22Dec2005.txt", "OUT22Dec2005.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200512p3.class, "DATA31Dec2005.txt", "OUT31Dec2005.txt");
		DwiteTestUtils.test(dwite200512p3.class, "DATA32Dec2005.txt", "OUT32Dec2005.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200512p4.class, "DATA41Dec2005.txt", "OUT41Dec2005.txt");
		DwiteTestUtils.test(dwite200512p4.class, "DATA42Dec2005.txt", "OUT42Dec2005.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200512p5.class, "DATA51Dec2005.txt", "OUT51Dec2005.txt");
		DwiteTestUtils.test(dwite200512p5.class, "DATA52Dec2005.txt", "OUT52Dec2005.txt");
	}
	
}
