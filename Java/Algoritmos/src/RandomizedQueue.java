import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] array;
	private int size;
	private int rear;

	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		// construct an empty randomized queue
		this.array = (Item[]) new Object[2];
	}

	public boolean isEmpty() {
		// is the queue empty?
		return this.size == 0;
	}

	public int size() {
		// return the number of items on the queue
		return this.size;
	}

	public void enqueue(Item item) {
		// add the item
		if (item == null) throw new NullPointerException();
		if (this.size == this.array.length) resize(this.size * 2);
		this.array[rear++] = item;
		this.size++;
	}

	public Item dequeue() {
		// remove and return a random item
		if (isEmpty()) throw new NoSuchElementException();
		int randomInt = StdRandom.uniform(this.size);
		Item item = this.array[randomInt];
		this.array[randomInt] = this.array[--this.rear];
		this.array[this.rear] = null;
		this.size--;
		if (this.size > 0 && this.size <= this.array.length / 4) resize(this.array.length / 2);
		return item;
	}

	public Item sample() {
		// return (but do not remove) a random item
		if (isEmpty()) throw new NoSuchElementException();
		int randomInt = StdRandom.uniform(this.size);
		return this.array[randomInt];
	}

	public Iterator<Item> iterator() {
		// return an independent iterator over items in random order
		return new ArrayIterator();
	}

	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		assert capacity >= this.size;
		Item[] aux = (Item[]) new Object[capacity];
		for(int i = 0; i < this.size; i++) {
			aux[i] = this.array[i];
		}
		this.array = aux;
	}

	public static void main(String[] args) {
		// unit testing
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
		queue.enqueue(458);
		System.out.println(queue.isEmpty());
		queue.enqueue(143);
		queue.enqueue(342);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

	private class ArrayIterator implements Iterator<Item> {

		private Item[] copy;
		private int current = 0;
		public void remove() { throw new UnsupportedOperationException(); }

		@SuppressWarnings("unchecked")
		public ArrayIterator() {
			// TODO Auto-generated constructor stub
			this.copy = (Item[]) new Object[size];
			for(int i = 0; i < size; i++) {
				this.copy[i] = array[i];
			}
			StdRandom.shuffle(this.copy);
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return this.current < size;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) throw new NoSuchElementException();
			return this.copy[this.current++];
		}

	}

}