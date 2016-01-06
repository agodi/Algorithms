package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SetOfStacks {

	private int currentStack = 0;
	private int threshold = 10;
	private List<AtomicInteger> info = new ArrayList<AtomicInteger>();

	private List<Integer[]> stacks = new ArrayList<Integer[]>();

	public void push(int i) {
		if (stacks.isEmpty() || info.get(currentStack).get() == threshold) {
			stacks.add(new Integer[threshold]);
			info.add(new AtomicInteger(0));
			if (stacks.size() > 1) currentStack++;
		}
		stacks.get(currentStack)[info.get(currentStack).get()] = i;
		info.get(currentStack).incrementAndGet();
	}

	public int pop() {

		while (stacks.get(currentStack)[info.get(currentStack).decrementAndGet()] == null) {
		}

		Integer aux = stacks.get(currentStack)[info.get(currentStack).get()];
		stacks.get(currentStack)[info.get(currentStack).get()] = null;
		if (info.get(currentStack).get() == 0) {
			stacks.remove(currentStack);
			info.remove(currentStack--);
		}
		return aux;
	}

	public int removeAt(int i) {
		while (stacks.get(i)[info.get(i).decrementAndGet()] == null) {
		}

		Integer aux = stacks.get(i)[info.get(i).get()];
		stacks.get(i)[info.get(i).get()] = null;
		if (info.get(i).get() == 0) {
			stacks.remove(i);
			info.remove(i);
			currentStack--;
		}
		return aux;

	}

	public static void main(String[] args) {
		SetOfStacks stacks = new SetOfStacks();
		for(int i = 0; i < 30; i++) {
			stacks.push(i);
		}
		
		for(int i = 0; i < 10; i++) {
			stacks.removeAt(1);
		}
		
		
		for(int i = 0; i < 20; i++) {
			System.out.println(stacks.pop());
		}

	}

}
