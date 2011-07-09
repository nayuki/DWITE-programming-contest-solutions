import org.junit.Test;


public class Dwite200612Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200612p1.class, "DATA11Dec2006.txt", "OUT11Dec2006.txt");
		DwiteTestUtils.test(dwite200612p1.class, "DATA12Dec2006.txt", "OUT12Dec2006.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200612p2.class, "DATA21Dec2006.txt", "OUT21Dec2006.txt");
		DwiteTestUtils.test(dwite200612p2.class, "DATA22Dec2006.txt", "OUT22Dec2006.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200612p3.class, "DATA31Dec2006.txt", "OUT31Dec2006.txt");
		DwiteTestUtils.test(dwite200612p3.class, "DATA32Dec2006.txt", "OUT32Dec2006.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200612p4.class, "DATA41Dec2006.txt", "OUT41Dec2006.txt");
		DwiteTestUtils.test(dwite200612p4.class, "DATA42Dec2006.txt", "OUT42Dec2006.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200612p5.class, "DATA51Dec2006.txt", "OUT51Dec2006.txt");
		DwiteTestUtils.test(dwite200612p5.class, "DATA52Dec2006.txt", "OUT52Dec2006.txt");
	}
	
}
