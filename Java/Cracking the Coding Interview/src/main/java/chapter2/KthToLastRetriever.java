package chapter2;

import util.LinkedListNode;

/**
 * Class to retrieve the kth to last element from a list
 * @author Arturo
 *
 */
public  class KthToLastRetriever {
    
	/**
	 * Traverses the whole list and starts tracking after kth nodes
	 * have been visited
	 * @param the list
	 * @param k the number of the desired node before the last one
	 * @return the kth to last node or null if the list has less than
	 * k nodes
	 */
    public static Integer retrieve(LinkedListNode<Integer> node, int k) {
        LinkedListNode<Integer> kth = node;
        int count = 0;
        while (node != null) {
            if (count > k) {
                kth = kth.next;
            }
            node = node.next;
            count++;
        }
        
        return (count < k)? null : kth.data;
    }

    public static void main(String[] args) {
		LinkedListNode<Integer> list = new LinkedListNode<Integer>(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		System.out.println(retrieve(list, 1));
	}

}