import org.junit.Test;


public class Dwite200711Test {
	
	@Test
	public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200711p1.class, "200711-DATA1.txt", "200711-OUT1.txt");
	}
	
	
	@Test
	public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200711p2.class, "200711-DATA2.txt", "200711-OUT2.txt");
	}
	
	
	@Test
	public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200711p3.class, "200711-DATA3.txt", "200711-OUT3.txt");
	}
	
	
	@Test
	public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200711p4.class, "200711-DATA4.txt", "200711-OUT4.txt");
	}
	
	
	@Test
	public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200711p5.class, "200711-DATA5.txt", "200711-OUT5.txt");
	}
	
}
