// DWITE - October 2004 - Problem 4: CD-ROM Files
public class dwite200410p4 {
	
	public static void main(String[] args) {
		new dwite200410p4(new DwiteIo("DATA4", "OUT4"));
	}
	
	
	dwite200410p4(DwiteIo io) {
		for (int i = 0; i < 5; i++)
			mainOnce(io);
		io.close();
	}
	
	
	private static void mainOnce(DwiteIo io) {
		io.tokenizeLine();
		int capacity = io.readIntToken();  // Variable A
		int files = io.readIntToken();     // Variable n
		
		// Solve subset sum problem using dynamic programming
		boolean[] possible = new boolean[capacity + 1];
		possible[0] = true;
		for (int i = 0; i < files; i++) {
			int filesize = io.readIntToken();  // Variable s_{i+1}
			for (int j = capacity - filesize; j >= 0; j--)
				possible[j + filesize] |= possible[j];
		}
		
		// Write the largest possible total size
		for (int i = capacity; i >= 0; i--) {
			if (possible[i]) {  // Guaranteed to execute before the loop ends
				io.println(i);
				break;
			}
		}
	}
	
}
