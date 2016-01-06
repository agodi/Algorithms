class MinPriorityQueue:

    def __init__(self, capacity):
        self.capacity = capacity
        self.array = []
        self.size = 0

    def add(self, i):
        self.array.append(i)
        self.swim(self.size)
        self.size += 1
        if(self.size > self.capacity):
            self.poll()

    def peek(self):
        return self.array[0]

    def poll(self):
        self.exchange(0, self.size - 1)
        self.sink(0)
        self.size -= 1
        return self.array.pop()

    def exchange(self, i, j):
        aux = self.array[i]
        self.array[i] = self.array[j]
        self.array[j] = aux

    def swim(self, i):
        while i > 0 and ((i - 1) / 2) >= 0:
            parent = (i - 1) / 2
            if self.array[i] < self.array[parent]:
                self.exchange(i, parent)
            i = parent

    def sink(self, i):
        while i < self.size and ((i * 2) + 1) < self.size:
            left_child = (i * 2) + 1
            right_child = (i * 2) + 2
            if (right_child < self.size and
                    self.array[right_child] > self.array[left_child]):
                left_child = right_child
            if self.array[i] > self.array[left_child]:
                self.exchange(i, left_child)
            i = left_child

    def __str__(self):
        return "capacity: " + str(self.capacity) + \
                " elements: " + str(self.array)

if __name__ == "__main__":
    pq = MinPriorityQueue(5)
    print pq
    pq.add(11)
    print pq
    pq.add(10)
    print pq
    pq.add(2)
    print pq
    pq.add(9)
    print pq
    pq.add(3)
    print pq
    pq.add(8)
    print pq
    pq.add(4)
    print pq
    pq.add(7)
    print pq
    pq.add(5)
    print pq
    pq.add(6)

    print pq