package Classwork7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	HashSet<GraphNode> graph;
	
	public Graph() {
		graph = new HashSet<>();
	}
	
	/**
	 * Connect nodes a and b. If graph is not weighted, 
	 * then the weight defaults to 1.
	 * @param a
	 * @param b
	 * @param weight
	 */
	
	public void connect(GraphNode a, GraphNode b) {
		graph.add(a);
		graph.add(b);
		a.addNeighbor(b);
		b.addNeighbor(a);
	}
	
	//weighted graph
	public void connect(GraphNode a, GraphNode b, int w) {
		graph.add(a);
		graph.add(b);
		a.addNeighbor(b, w);
		b.addNeighbor(a, w);
	}
	
	/**
	 * Delete the GraphNode and remove all the
	 * connecting edges to this node.
	 * @param n
	 * @return
	 */
	public void delete(GraphNode n) {
		graph.remove(n);
		for (GraphNode key : graph){
			key.removeNeighbor(n);
		}
	}
	
	/**
	 * Perform Breadth First Search on the graph.
	 * Print each node you visit.
	 * @param initNode
	 */
	public void bfs(GraphNode initNode) {
		Queue<GraphNode> queue = new LinkedList<>();
		HashSet<GraphNode> visited = new HashSet<>();
		queue.add(initNode);
		visited.add(initNode);
		while (!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			System.out.println(cur);
			for (Pair neighbor : cur.getNeighbors()){
				if (!visited.contains(neighbor.destination)){
					queue.add(neighbor.destination);
					visited.add(neighbor.destination);
				}
			}
		}
	}
	
	/**
	 * Perform Depth First Search on the graph.
	 * Print each node you visit.
	 * @param initNode
	 */
	public void dfs(GraphNode initNode) {
		Stack<GraphNode> stack = new Stack<>();
		HashSet<GraphNode> visited = new HashSet<>();
		stack.push(initNode);
		visited.add(initNode);
		while(!stack.isEmpty()) {
			GraphNode cur = stack.pop();
			System.out.println(cur);
			for (Pair neighbor : cur.getNeighbors()){
				if (!visited.contains(neighbor.destination)){
					stack.push(neighbor.destination);
					visited.add(neighbor.destination);
				}
			}
		}
	}

	public void recursiveDFS(GraphNode initNode) {
		HashSet<GraphNode> visited = new HashSet<>();
		recursiveDFSHelper(initNode, visited);
	}

	private void recursiveDFSHelper(GraphNode initNode, HashSet<GraphNode> visited){
		visited.add(initNode);
		System.out.println(initNode);
		for (Pair neighbor : initNode.getNeighbors()){
			if (!visited.contains(neighbor.destination)){
				recursiveDFSHelper(neighbor.destination, visited);
			}
		}
	}
	
	/**
	 * Given two nodes, a and b, find the shortest
	 * path if it exits. Shortest path is defined
	 * in terms of edge weights (aka smallest weight sum).
	 * @param a
	 * @param b
	 */
	public void shortestPath(GraphNode a, GraphNode b) {
		//TODO
	}
	
	/**
	 * Can we color the graph in such a way that
	 * each neighbor is of alternating red/blue color?
	 * @return
	 */
	public boolean isBipartite() {
		//TODO
		return false;
	}
	
	/**
	 * Are all the nodes connected to each other?
	 * @return
	 */
	public boolean isConnected() {
		int maxConnections = graph.size()-1;
		for (GraphNode key : graph){
			if (key.degree() != maxConnections) return false;
		}
		return true;
	}
}
