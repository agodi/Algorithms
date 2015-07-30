package chapter2;

import util.LinkedListNode;

/**
 * Class to find the node where a cycle begins in a
 * linked list
 * @author Arturo
 *
 */
public class LinkedListLoopFinder {

	/**
	 * Finds the node which starts a cycle in a linked list
	 * @param list
	 * @return data of the node beginning the cycle 
	 * 		   or null if there is no cycle
	 */
	public static Integer findCyclicNode(LinkedListNode<Integer> list) {
		LinkedListNode<Integer> slow = list;
		LinkedListNode<Integer> fast = list;
		
		// determine if there is a cycle in the list
		while (true) {
			if (fast == null || fast.next == null) return null;
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) break;
		}
		
		slow = list;
		
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow.data;
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> loop = new LinkedListNode<Integer>(99);
		LinkedListNode<Integer> list = new LinkedListNode<Integer>(1);
		list.add(2);
		list.add(3);
		list.add(loop);
		list.add(4);
		list.add(5);
		list.add(loop);
		System.out.println(findCyclicNode(list));
	}

}
