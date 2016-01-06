package chapter2;

import util.LinkedListNode;

/**
 * Class to find the intersecting node of two lists
 * @author Arturo
 *
 */
public class LinkedListsIntersectionFinder {

	/**
	 * Finds the node at which two lists intersect
	 * @param list1
	 * @param list2
	 * @return the node where the two lists intersect or null
	 * 		   if the lists do not intersect
	 */
	public static LinkedListNode<Integer> findIntersection(LinkedListNode<Integer> list1, 
									LinkedListNode<Integer> list2) {
		// lists do not intersect
		if (list1 == null || 
			list2 == null || 
			getTail(list1) != getTail(list2)) return null;
		LinkedListNode<Integer> max = list1.size() >= list2.size() ? list1 : list2;
		LinkedListNode<Integer> min = (max == list2) ? list1 : list2;
		int delta = max.size() - min.size();
		
		while(delta != 0) {
			max = max.next;
			delta--;
		}
		
		while(max != min) {
			max = max.next;
			min = min.next;
		}
		
		return max;
	}
	
	/**
	 * Finds the last node of a list
	 * @param list
	 * @return the last node of the list or null
	 * 			if the list is empty
	 */
	public static LinkedListNode<Integer> getTail(LinkedListNode<Integer> list) {
		if (list == null) return null;
		while(list.next != null) list = list.next;
		return list;
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> commonList = new LinkedListNode<Integer>(6);
		commonList.add(66);
		commonList.add(666);
		LinkedListNode<Integer> list1 = new LinkedListNode<Integer>(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(commonList);
		LinkedListNode<Integer> list2 = new LinkedListNode<Integer>(1);
		list2.add(1);
		list2.add(1);
		list2.add(commonList);
		System.out.println(findIntersection(list1, list2));
	}

}
