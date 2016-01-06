package chapter3;

import java.util.Stack;

/**
 * Stack which in addition has a function min()
 * which returns the minimum element in the stack
 * with complexity O(1)
 * @author Arturo
 *
 */
public class MinStack {
	
	private Stack<Integer> values = new Stack<Integer>();
	
	private Stack<Integer> mins = new Stack<Integer>();
	
	public void push(Integer integer) {
		this.values.push(integer);
		if(this.mins.isEmpty() || integer <= this.mins.peek()) {
			this.mins.push(integer);
		}
	}
	
	public Integer pop() {
		if (this.mins.peek() == this.values.peek()) this.mins.pop();
		return this.values.pop();
	}

	public Integer min() {
		return this.mins.peek();
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(3);
		stack.push(5);
		stack.push(1);
		stack.push(7);
		stack.push(0);
		stack.push(8);
		System.out.println("min: " + stack.min());
		System.out.println("pop: " + stack.pop());
		System.out.println("min: " + stack.min());
		System.out.println("pop: " + stack.pop());
		System.out.println("min: " + stack.min());
		System.out.println("pop: " + stack.pop());
		System.out.println("min: " + stack.min());
		System.out.println("pop: " + stack.pop());
		System.out.println("min: " + stack.min());
		System.out.println("pop: " + stack.pop());
		System.out.println("min: " + stack.min());
		System.out.println("pop: " + stack.pop());
	}

}
