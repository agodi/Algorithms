package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a basic node in a graph
 * linked list
 * @author Arturo
 *
 * @param <T> generic type of the data to be hold
 */
public class GraphNode<T> {
	
	public List<GraphNode<T>> adjacentNodes = new ArrayList<GraphNode<T>>();
	public T data;
	public boolean isVisited;
	
	/**
	 * Constructor to initialize a node
	 * @param data to be hold by this node
	 */
	public GraphNode(T data) {
		this.data = data;
	}
	
	/**
	 * Inserts a new node to the adjacentNodes List
	 * @param node
	 */
	public void add(GraphNode<T> t) {
		this.adjacentNodes.add(t);
	}
	
	/**
	 * Returns a string containing the data of all the nodes
	 * accessible from this node
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (GraphNode<T> node : adjacentNodes) {
			sb.append(node.data.toString());
			sb.append(", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append("]");
		return sb.toString();
	}

}
