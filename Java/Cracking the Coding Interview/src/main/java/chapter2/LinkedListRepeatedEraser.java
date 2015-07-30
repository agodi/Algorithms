package chapter2;

import java.util.HashMap;
import java.util.Map;

import util.LinkedListNode;

/**
 * Class to delete repeated values in a linked list
 * @author Arturo
 *
 */
public class LinkedListRepeatedEraser {
	
	/**
	 * Removes a node from the list if it is repeated
	 * @param head node of the linked list 
	 */
	public static void removeDuplicates(LinkedListNode<Integer> node) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		LinkedListNode<Integer> previous = null;
		while (node != null) {
			if(map.containsKey(node.data)) {
				previous.next = node.next;
			} else {
				map.put(node.data, node.data);
				previous = node;
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
