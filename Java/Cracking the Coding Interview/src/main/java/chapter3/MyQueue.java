package chapter3;

import java.util.Stack;

public class MyQueue {
	
	private Stack<Integer> enqueueStack = new Stack<Integer>();
	private Stack<Integer> dequeueStack = new Stack<Integer>();

	public void enqueue(Integer item) {
		enqueueStack.push(item);
	}
	
	public Integer dequeue() {
		if (dequeueStack.empty()) {
			while(!enqueueStack.empty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		return dequeueStack.pop();
	}
	
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		for(int i = 0; i < 30; i++) {
			queue.enqueue(i);
		}
		
		for(int i = 0; i < 20; i++) {
			System.out.println(queue.dequeue());
		}

	}

}
