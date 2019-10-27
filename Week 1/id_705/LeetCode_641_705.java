class MyCircularDeque {

    private int front;
    private int rear;
    private int size;
    private int capacity;
    private int[] data;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = k;
        this.data = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (front == rear && size == capacity)  {
            return false;
        }
        front = (front + capacity - 1) % capacity;
        data[front] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (front == rear && size == capacity) {
            return false;
        }
        data[rear] = value;
        rear = (capacity + rear + 1) % capacity;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (front == rear && size == 0) {
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (front == rear && size == 0) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return size == 0 ? -1 : data[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return size == 0 ? -1 : data[(rear - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front ==  rear && size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return front == rear && size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */