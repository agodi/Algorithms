package chapter2;

import util.LinkedListNode;

/**
 * Class to delete repeated values in a linked list
 * without using any additional data structure
 * @author Arturo
 *
 */
public class LinkedListRepeatedEraserInPlace {

	/**
	 * Removes a node from the list if it is repeated
	 * @param head node of the linked list 
	 */
	public static void removeDuplicates(LinkedListNode<Integer> node) {
		while (node != null) {
			LinkedListNode<Integer> current = node;
			while (current.next != null) {
				if(node.data.equals(current.next.data)) {
					current.next = current.next.next;
				} else {
					current = current.next;
				}
			}
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> list = new LinkedListNode<Integer>(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		removeDuplicates(list);
		System.out.println(list);
	}

}
