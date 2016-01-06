package chapter2;

import util.LinkedListNode;

/**
 * Class to partition a linked list putting nodes which value is less than a
 * given value before nodes which value is grater than or equal to it
 * 
 * @author Arturo
 *
 */
public class LinkedListPartitioner {

	/**
	 * Rearrenges a list putting nodes which value is less than a given value
	 * before nodes which value is grater than or equal to it
	 * 
	 * @param list
	 * @param value
	 */
	public static LinkedListNode<Integer> partition(LinkedListNode<Integer> list, int value) {
		LinkedListNode<Integer> minHead = null;
		LinkedListNode<Integer> min = null;
		LinkedListNode<Integer> maxHead = null;
		LinkedListNode<Integer> max = null;
		LinkedListNode<Integer> current = list;
		while(current != null) {
			if (current.data < value) {
				if (minHead == null) {
					minHead = current;
					min = current;
				} else {
					min.next = current;
					min = min.next;
				}
			} else {
				if (maxHead == null) {
					maxHead = current;
					max = current;
				} else {
					max.next = current;
					max = max.next;
				}
			}
			current = current.next;
		}
		min.next = maxHead;
		max.next = null;
		return minHead;
	}

	public static void main(String[] args) {
		LinkedListNode<Integer> list = new LinkedListNode<Integer>(0);
		list.add(1);
		list.add(2);
		list.add(7);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(5);
		System.out.println(partition(list, 4));
	}

}
