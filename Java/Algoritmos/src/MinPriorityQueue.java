import java.util.Arrays;

public class MinPriorityQueue {

  private int capacity;
  private int size;
  private Integer[] array;
  
  public MinPriorityQueue(int capacity) {
    this.capacity = capacity;
    this.array = new Integer[capacity];
    this.size = 0;
  }
  
  public void add(int i) {
    if (this.size == 0 || this.size < this.capacity || i > this.array[0]) {
      if (this.size == this.capacity) {
        this.poll();
      }
      this.array[this.size] = i;
      this.swim(this.size++);
    }
  }
  
  public int peek() {
    return this.array[0];
  }

  public int poll() {
    this.exchange(0, --this.size);
    int aux = this.array[this.size];
    this.array[this.size] = null;
    this.sink(0);
    return aux;
  }
  
  public void exchange(int i, int j) {
    int aux = this.array[i];
    this.array[i] = this.array[j];
    this.array[j] = aux;
  }
  
  public void swim(int i) {
    while (i > 0 && ((i - 1) / 2) >= 0) {
      int parent = (i - 1) / 2;
      if (this.array[i] < this.array[parent]) {
         this.exchange(i, parent);
      }
      i = parent;
    }
  }
  
  public void sink(int i) {
    while (i < this.size && ((i * 2) + 1) < this.size) {
       int leftChild = (i * 2) + 1;
       int rightChild = (i * 2) + 2;
       if (rightChild < this.size && 
           this.array[rightChild] < this.array[leftChild]) {
         leftChild = rightChild;
       }
       if (this.array[i] > this.array[leftChild]) {
         this.exchange(i, leftChild);
       }
       i = leftChild;
    }
  }

  @Override
  public String toString() {
    return Arrays.toString(this.array);
  }

  public static void main(String[] args) {
      MinPriorityQueue pq = new MinPriorityQueue(5);
      
//      pq.add(11);
//      pq.add(10);
//      pq.add(2);
//      pq.add(9);
//      pq.add(3);
//      pq.add(8);
//      pq.add(4);
//      pq.add(7);
//      pq.add(5);
//      pq.add(6);
      
//      pq.add(1);
//      pq.add(2);
//      pq.add(3);
//      pq.add(4);
//      pq.add(5);
//      pq.add(6);
//      pq.add(7);
//      pq.add(8);
//      pq.add(9);
//      pq.add(10);
      
      pq.add(10);
      pq.add(9);
      pq.add(8);
      pq.add(7);
      pq.add(6);
      pq.add(5);
      pq.add(4);
      pq.add(3);
      pq.add(2);
      pq.add(1);
      pq.add(0);

      System.out.println(pq); 
  }

}

