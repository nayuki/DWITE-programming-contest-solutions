import org.junit.Test;


public final class Dwite200412Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200412p1.class, "DATA11Dec2004.txt", "OUT11Dec2004.txt");
		DwiteTestUtils.test(dwite200412p1.class, "DATA12Dec2004.txt", "OUT12Dec2004.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200412p2.class, "DATA21Dec2004.txt", "OUT21Dec2004.txt");
		DwiteTestUtils.test(dwite200412p2.class, "DATA22Dec2004.txt", "OUT22Dec2004.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200412p3.class, "DATA31Dec2004.txt", "OUT31Dec2004.txt");
		DwiteTestUtils.test(dwite200412p3.class, "DATA32Dec2004.txt", "OUT32Dec2004.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200412p4.class, "DATA41Dec2004.txt", "OUT41Dec2004.txt");
		DwiteTestUtils.test(dwite200412p4.class, "DATA42Dec2004.txt", "OUT42Dec2004.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200412p5.class, "DATA51Dec2004.txt", "OUT51Dec2004.txt");
		DwiteTestUtils.test(dwite200412p5.class, "DATA52Dec2004.txt", "OUT52Dec2004.txt");
	}
	
}
