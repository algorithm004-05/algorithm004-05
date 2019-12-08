package leetcode.jacf.tech;


/**
 * 双端环形队列，首尾指针需要注意要考虑加减capacity
 */
public class DesignCircularDeque {

    int[] contents;
    private int size = 0;
    private int capacity = 0;
    private int front = 0;
    private int rear = 0;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public DesignCircularDeque(int k) {
        contents = new int[k];
        capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (!this.isFull()) {
            front = (front + capacity - 1) % capacity;
            contents[front] = value;
            size++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (!this.isFull()) {
            contents[rear] = value;
            rear = (rear + capacity + 1) % capacity;
            size++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (!this.isEmpty()) {
            front = (front + 1) % capacity;
            size--;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (!this.isEmpty()) {
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return this.isEmpty() ? -1 : contents[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return this.isEmpty() ? -1 : contents[rear];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return (rear == front) && (size == 0);
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (rear == front) && (size == capacity);
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
