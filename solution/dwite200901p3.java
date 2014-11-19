/* 
 * DWITE - January 2009 - Problem 3: Secret party
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Set;
import java.util.TreeSet;


public final class dwite200901p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200901p3().run("DATA3.txt", "OUT3.txt");
	}
	
	
	private int[][] relationships;
	
	protected void runOnce() {
		// Read input
		relationships = new int[io.readIntLine()][2];
		for (int i = 0; i < relationships.length; i++) {
			io.tokenizeLine();
			relationships[i][0] = io.readIntToken();
			relationships[i][1] = io.readIntToken();
			// Nullify a (1, 2) relationship
			if (relationships[i][0] == 1 && relationships[i][1] == 2 || relationships[i][0] == 2 && relationships[i][1] == 1) {
				relationships[i][0] = 0;
				relationships[i][1] = 0;
			}
		}
		
		// Compute friend sets
		Set<Integer> invite = new TreeSet<Integer>();
		getFriends(1, 1, invite);
		invite.remove(1);
		Set<Integer> uninvite = new TreeSet<Integer>();
		getFriends(2, 2, uninvite);
		invite.removeAll(uninvite);
		
		// Format output
		if (invite.size() == 0)
			io.println("none");
		else {
			boolean head = true;
			for (int id : invite) {
				if (head)
					head = false;
				else
					io.print(" ");
				io.print(id);
			}
			io.println();
		}
	}
	
	
	private void getFriends(int node, int levels, Set<Integer> result) {
		if (result.contains(node))
			return;
		result.add(node);
		if (levels > 0) {
			for (int[] relation : relationships) {
				if (relation[0] == node)
					getFriends(relation[1], levels - 1, result);
				if (relation[1] == node)
					getFriends(relation[0], levels - 1, result);
			}
		}
	}
	
}
