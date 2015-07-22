package util;

/**
 * Class to represent a basic node in a single
 * linked list
 * @author Arturo
 *
 * @param <T> generic type of the data to be hold
 */
public class LinkedListNode<T> {
	
	public LinkedListNode<T> next;
	public T data;
	
	/**
	 * Constructor to initialize a node
	 * @param data to be hold by this node
	 */
	public LinkedListNode(T data) {
		this.data = data;
	}
	
	/**
	 * Iterates through the node, starting at this node,
	 * and insert a new node with the given data
	 * at the end
	 * @param t
	 */
	public void add(T t) {
		LinkedListNode<T> node = this;
		while (node.next != null) {
			node = node.next;
		}
		node.next = new LinkedListNode<T>(t);
	}
	
	/**
	 * Returns a string containing the data of all the nodes
	 * accessible from this node
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinkedListNode<T> node = this;
		sb.append("[");
		while (node != null) {
			sb.append(node.data.toString());
			sb.append(", ");
			node = node.next;
		}
		sb.setLength(sb.length() - 2);
		sb.append("]");
		return sb.toString();
	}

}
