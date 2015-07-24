package chapter2;

import java.util.Stack;

import util.LinkedListNode;

/**
 * Class to identify if a list is a palindrome
 * @author Arturo
 *
 */
public class PalindromeDetector {
	
	/**
	 * Compares the values in the list in reverse order
	 * @param list
	 * @return true if the values in the list are the same
	 * backwards and forwards
	 * false otherwise
	 */
	public static boolean isPalindrome(LinkedListNode<Integer> list) {
		Stack<Integer> stack = new Stack<Integer>();
		LinkedListNode<Integer> aux = list;
		while (aux != null) {
			stack.push(aux.data);
			aux = aux.next;
		}
		
		while (list != null) {
			if (stack.pop() != list.data) return false;
			list = list.next;
		}
		
		return stack.isEmpty();
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
		list.add(0);
		System.out.println(isPalindrome(list));
	}

}
