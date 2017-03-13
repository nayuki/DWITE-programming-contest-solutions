import org.junit.Test;


public final class Dwite200911Test {
	
	@Test public void testProblem1() throws Exception {
		DwiteTestUtils.test(dwite200911p1.class, "200911-DATA1.txt", "200911-OUT1.txt");
	}
	
	
	@Test public void testProblem2() throws Exception {
		DwiteTestUtils.test(dwite200911p2.class, "200911-DATA2.txt", "200911-OUT2.txt");
	}
	
	
	@Test public void testProblem3() throws Exception {
		DwiteTestUtils.test(dwite200911p3.class, "200911-DATA3.txt", "200911-OUT3.txt");
	}
	
	
	@Test public void testProblem4() throws Exception {
		DwiteTestUtils.test(dwite200911p4.class, "200911-DATA4.txt", "200911-OUT4.txt");
	}
	
	
	@Test public void testProblem5() throws Exception {
		DwiteTestUtils.test(dwite200911p5.class, "200911-DATA5.txt", "200911-OUT5.txt");
	}
	
}
