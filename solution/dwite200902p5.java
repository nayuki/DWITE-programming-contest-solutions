/* 
 * DWITE programming contest solutions
 * February 2009 - Problem 5: "Nash in Traffic"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public final class dwite200902p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200902p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void runOnce() {
		// Parse input
		int people = io.readIntLine();
		Node[] nodes = new Node[26];
		for (int i = 0; i < nodes.length; i++)
			nodes[i] = new Node();
		int roads = io.readIntLine();
		for (int i = 0; i < roads; i++) {
			io.tokenizeLine();
			String link = io.readToken();
			String expr = io.readToken();
			Node from = nodes[link.charAt(0) - 'A'];
			Node to   = nodes[link.charAt(1) - 'A'];
			from.outEdges.add(new Edge(to, expr));
		}
		
		int time = 0;
		for (int i = 0; i < people; i++) {
			// Reset arrival times
			for (Node node : nodes)
				node.arrivalTime = Double.POSITIVE_INFINITY;
			nodes[0].arrivalTime = 0;
			
			// Bellman-Ford algorithm
			for (int j = 0; j < 26; j++) {
				for (Node node : nodes) {
					for (Edge edge : node.outEdges)
						edge.target.arrivalTime = Math.min(node.arrivalTime + edge.getNextCarTravelTime(), edge.target.arrivalTime);
				}
			}
			time = Math.max((int)Math.round(nodes[25].arrivalTime), time);
			
			// Increment flow on the path
			Node node = nodes[25];
			do {
				middle:
				for (Node n : nodes) {
					for (Edge e : n.outEdges) {
						if (e.target == node && n.arrivalTime + e.getNextCarTravelTime() == node.arrivalTime) {
							e.flow++;
							node = n;
							break middle;
						}
					}
				}
			} while (node != nodes[0]);
		}
		io.println(time);
	}
	
	
	
	private static final class Node {
		
		public Set<Edge> outEdges;
		
		public double arrivalTime;
		
		
		public Node() {
			outEdges = new HashSet<Edge>();
		}
		
	}
	
	
	
	private static final class Edge {
		
		public final Node target;
		
		public final Object[] travelTimeExpression;
		
		public int flow;
		
		
		public Edge(Node target, String expr) {
			this.target = target;
			flow = 0;
			
			// Convert to reverse Polish notation
			List<Object> ops = new ArrayList<Object>();
			Stack<Character> operators = new Stack<Character>();
			while (expr.length() > 0) {
				int i = 0;
				while (i < expr.length() && expr.substring(i, i + 1).matches("[0-9.]"))
					i++;
				if (i > 0) {
					ops.add(new Double(expr.substring(0, i)));
					expr = expr.substring(i);
				} else {
					char c = expr.charAt(0);
					switch (c) {
						case 'x':
							ops.add(c);
							break;
						case '+':
						case '-':
							while (!operators.isEmpty())
								ops.add(operators.pop());
							operators.push(c);
							break;
						case '*':
						case '/':
							while (!operators.isEmpty()) {
								char op = operators.peek();
								if (op == '*' || op == '/')
									ops.add(operators.pop());
								else
									break;
							}
							operators.push(c);
							break;
						default:
							throw new IllegalArgumentException();
					}
					expr = expr.substring(1);
				}
			}
			while (!operators.isEmpty())
				ops.add(operators.pop());
			travelTimeExpression = ops.toArray();
		}
		
		
		public double getNextCarTravelTime() {
			Stack<Double> stack = new Stack<Double>();
			for (Object op : travelTimeExpression) {
				if (op instanceof Double)
					stack.push((Double)op);
				else if (op instanceof Character) {
					switch ((Character)op) {
						case 'x':
							stack.push(flow + 1.0);
							break;
						case '+':
							stack.push(stack.pop() + stack.pop());
							break;
						case '-':
							stack.push(-stack.pop() + stack.pop());
							break;
						case '*':
							stack.push(stack.pop() * stack.pop());
							break;
						case '/':
							stack.push(1 / stack.pop() * stack.pop());
							break;
						default:
							throw new AssertionError();
					}
				} else
					throw new AssertionError();
			}
			
			if (stack.size() != 1)
				throw new IllegalStateException();
			return stack.peek();
		}
		
	}
	
}
