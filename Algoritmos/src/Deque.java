import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node head;
	private Node tail;
	private int size;

	public Deque() {
		// construct an empty deque

	}

	public boolean isEmpty() {
		// is the deque empty?
		return this.size == 0;
	}

	public int size() {
		// return the number of items on the deque
		return this.size;
	}

	public void addFirst(Item item) {
		// add the item to the front
		if (item == null) throw new NullPointerException();
		else {
			Node oldFirst = this.head;
			Node node = new Node(item);
			node.next = oldFirst;
			size++;
			if (this.size == 1) this.tail = node;
			if (this.size > 1) oldFirst.previous = node;
			this.head = node;
		}
	}

	public void addLast(Item item) {
		// add the item to the end
		if (item == null) throw new NullPointerException();
		else {
			Node oldLast = this.tail;
			Node node = new Node(item);
			node.previous = oldLast;
			size++;
			if (this.size == 1) this.head = node;
			if (this.size > 1) oldLast.next = node;
			this.tail = node;
		}
	}

	public Item removeFirst() {
		// remove and return the item from the front
		if (isEmpty()) throw new NoSuchElementException();
		Node node = this.head;
		this.head = node.next;
		size--;
		if (isEmpty()) this.tail = null;
		else this.head.previous = null;
		return node.item;
	}

	public Item removeLast() {
		// remove and return the item from the end
		if (isEmpty()) throw new NoSuchElementException();
		Node node = this.tail;
		this.tail = node.previous;
		size--;
		if (isEmpty()) this.head = null;
		else this.tail.next = null;
		return node.item;
	}

	public Iterator<Item> iterator() {
		// return an iterator over items in order from front to end
		return new ListIterator();
	}

	public static void main(String[] args) {
	}

	private class Node {

		private Item item;
		private Node next;
		private Node previous;

		private Node(Item t) {
			this.item = t;
		}

	}

	private class ListIterator implements Iterator<Item> {

		private Node current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Node node = current;
			current = node.next;
			return node.item;
		}

		public void remove() { throw new UnsupportedOperationException(); }

	}

}
