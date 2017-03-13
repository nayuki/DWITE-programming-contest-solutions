/* 
 * DWITE programming contest solutions
 * October 2012 - Problem 4: "Trick or Tree'ing"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201210p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201210p4().run("DATA4.txt", "OUT4.txt");
	}
	
	
	private String line;
	private int candy;
	
	protected void runOnce() {
		candy = 0;
		line = io.readLine();
		index = 0;
		Node tree = parseTree();
		io.println(minimumWalk(tree) + " " + candy);
	}
	
	
	private int index;
	
	private Node parseTree() {
		if (index >= line.length())
			throw new IllegalArgumentException();
		
		while (line.charAt(index) == ' ')
			index++;
		
		if (line.charAt(index) == '(') {
			index++;
			Node left = parseTree();
			Node right = parseTree();
			if (line.charAt(index) != ')')
				throw new IllegalArgumentException();
			index++;
			return new Node(left, right);
			
		} else {
			int start = index;
			while (index < line.length() && Character.isDigit(line.charAt(index)))
				index++;
			candy += Integer.parseInt(line.substring(start, index));
			return null;  // Leaf
		}
	}
	
	
	private int minimumWalk(Node node) {
		if (node == null)
			return 0;
		else
			return Math.min(fullWalk(node.left) + minimumWalk(node.right), minimumWalk(node.left)+ fullWalk(node.right)) + 3;
	}
	
	
	private int fullWalk(Node node) {
		if (node == null)
			return 0;
		else
			return fullWalk(node.left) + fullWalk(node.right) + 4;
	}
	
	
	
	private static final class Node {
		
		public final Node left;
		public final Node right;
		
		
		public Node(Node left, Node right) {
			this.left = left;
			this.right = right;
		}
		
	}
	
}
