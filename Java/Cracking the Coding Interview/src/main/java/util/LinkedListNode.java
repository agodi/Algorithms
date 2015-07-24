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
	 * and inserts a new node with the given data
	 * at the end
	 * @param data to be contained in the new node
	 */
	public void add(T t) {
		LinkedListNode<T> node = this;
		while (node.next != null) {
			node = node.next;
		}
		node.next = new LinkedListNode<T>(t);
	}
	
	/**
	 * Iterates through the list, starting at this node,
	 * and inserts the given node at the end
	 * @param the node to insert
	 */
	public void add(LinkedListNode<T> node) {
		LinkedListNode<T> current = this;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
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
