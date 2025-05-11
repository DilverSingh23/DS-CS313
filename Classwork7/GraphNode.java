package Classwork7;

import java.util.ArrayList;

public class GraphNode {
	private int data;
	private ArrayList<Pair> adjList;
	
	public GraphNode(int d) {
		data = d;
		adjList = new ArrayList<>();
	}
	
	public void addNeighbor(GraphNode d) {
		adjList.add(new Pair(d));
	}
	
	public void addNeighbor(GraphNode d, int weight) {
		adjList.add(new Pair(d,weight));
	}
	
	public void removeNeighbor(GraphNode n) {
		for(int i = 0; i < adjList.size(); i++){
			if (adjList.get(i).destination == n){
				adjList.remove(i);
				break;
			}
		}
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int d) {
		data = d;
	}
	
	/**
	 * Return the degree of the node
	 * @return
	 */
	public int degree() {
		return adjList.size();
	}	
	
	/**
	 * Return the neighbor arraylist
	 * @return
	 */
	public ArrayList<Pair> getNeighbors(){
		return adjList;
	}
}
