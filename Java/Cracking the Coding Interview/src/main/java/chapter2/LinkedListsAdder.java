package chapter2;

import util.LinkedListNode;

/**
 * Class to add the digits contained in two lists in representing an integer in
 * reverse order
 * 
 * @author Arturo
 *
 */
public class LinkedListsAdder {

	/**
	 * Sums the digits contained in two lists in
	 * representing an integer in reverse order
	 * @param list1
	 * @param list2
	 * @return sum of the two lists
	 */
	public static LinkedListNode<Integer> sum(LinkedListNode<Integer> list1, LinkedListNode<Integer> list2) {
		LinkedListNode<Integer> max = list1.size() >= list2.size() ? list1 : list2;
		LinkedListNode<Integer> min = (max == list2) ? list1 : list2;
		LinkedListNode<Integer> aux = max;
		int delta = max.size() - min.size();
		
		while(delta != 0) {
			aux = aux.next;
			delta--;
		}
		
		while(min != null) {
			aux.data += min.data;
			aux = aux.next;
			min = min.next;
		}
		return max;
	}

	public static void main(String[] args) {
		LinkedListNode<Integer> list1 = new LinkedListNode<Integer>(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		LinkedListNode<Integer> list2 = new LinkedListNode<Integer>(1);
		list2.add(1);
		list2.add(1);
		System.out.println(sum(list1, list2));
	}

}
