/* 
 * DWITE - November 2007 - Problem 5: Bridges In A Graph
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200711p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200711p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		int numVertices = io.readIntLine();
		int numEdges = io.readIntLine();
		int[][] edges = new int[numEdges][2];
		for (int i = 0; i < numEdges; i++) {
			io.tokenizeLine();
			edges[i][0] = io.readIntToken() - 1;
			edges[i][1] = io.readIntToken() - 1;
		}
		
		// Exclude each edge one by one and use union-find
		int bridges = 0;
		for (int[] excludedEdge : edges) {
			// Add all edges except the excluded one
			DisjointSets ds = new DisjointSets(numVertices);
			for (int[] edge : edges) {
				if (edge != excludedEdge)
					ds.union(edge[0], edge[1]);
			}
			
			// Test connectivity
			Node repr = ds.find(0);
			for (int i = 1; i < numVertices; i++) {
				if (ds.find(i) != repr) {
					bridges++;
					break;
				}
			}
		}
		io.println(bridges);
	}
	
	
	
	private static final class DisjointSets {
		
		private Node[] nodes;
		
		
		public DisjointSets(int size) {
			nodes = new Node[size];
			for (int i = 0; i < size; i++)
				nodes[i] = new Node();
		}
		
		
		// Returns the representative of node i.
		public Node find(int i) {
			Node node = nodes[i];
			if (node.parent == node)
				return node;
			else {
				Node temp = node;
				while (temp.parent != temp)
					temp = temp.parent;
				node.parent = temp;  // Path compression
				return temp;
			}
		}
		
		
		// Combines the set that node i belongs to and the set that node j belongs to.
		public void union(int i, int j) {
			Node x = find(i);
			Node y = find(j);
			if (x == y)
				return;
			else if (x.rank < y.rank)
				x.parent = y;
			else if (x.rank > y.rank)
				y.parent = x;
			else {
				x.parent = y;
				y.rank++;
			}
		}
		
	}
	
	
	
	private static final class Node {
		
		public Node parent;
		public int rank;
		
		
		public Node() {
			parent = this;
			rank = 0;
		}
		
	}
	
}
