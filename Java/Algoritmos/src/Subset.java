public class Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j = Integer.valueOf(args[0]);
		RandomizedQueue<String> queue = new RandomizedQueue<String>();

		while(!StdIn.isEmpty()) {
			queue.enqueue(StdIn.readString());
		}

		for (int i=0; i<j; i++) {
			System.out.println(queue.dequeue());
		}
	}

}
