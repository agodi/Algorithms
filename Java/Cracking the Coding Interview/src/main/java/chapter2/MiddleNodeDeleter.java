package chapter2;

import util.LinkedListNode;

/**
 * Class to delete a node in the beginning or middle of a list
 * @author Arturo
 *
 */
public class MiddleNodeDeleter {
	
	/**
	 * Iterates through the list copying the value from the next node to
	 * this node and making the reference to the last node null
	 * @param node from which the values will be copied
	 */
	public static void deleteNode(LinkedListNode<Integer> node) {
		LinkedListNode<Integer> previous = node;
		while (node.next != null) {
			previous = node;
			node.data = node.next.data;
			node = node.next;
		}
		previous.next = null;
	}

	public static void main(String[] args) {
		int i = 0;
		LinkedListNode<Integer> node = new LinkedListNode<Integer>(500);
		LinkedListNode<Integer> list = new LinkedListNode<Integer>(i++);
		list.add(i++);
		list.add(i++);
		list.add(i++);
		list.add(i++);
		list.add(node);
		list.add(i++);
		list.add(i++);
		list.add(i++);
		list.add(i++);
		list.add(i++);
		System.out.println(list);
		deleteNode(node);
		System.out.println(list);
	}

}
