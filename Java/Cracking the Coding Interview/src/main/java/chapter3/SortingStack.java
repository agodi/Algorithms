package chapter3;

import java.util.Stack;

public class SortingStack {
	
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> temp = new Stack<Integer>();

	public void push(Integer item) {
		if(stack.empty() || item < stack.peek()) stack.push(item);
		else {
			while (!stack.empty() && stack.peek() < item) 
				temp.push(stack.pop());
			stack.push(item);
			while (!temp.empty()) stack.push(temp.pop());
		}
	}
	
	public Integer pop() {
		return stack.pop();
	}


	public static void main(String[] args) {
		SetOfStacks stacks = new SetOfStacks();
		for(int i = 30; i > 0; i--) {
			stacks.push(i);
		}
		
		for(int i = 0; i < 30; i++) {
			System.out.println(stacks.pop());
		}
	}

}
