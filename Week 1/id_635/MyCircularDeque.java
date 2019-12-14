//MyCircularDeque
public class MyCircularDeque {
    private int[] myQueue;
    private int len;
    private int headIdx;
    private int tailIdx;

    /**
     * Initialize your data structure here. Set the len of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.myQueue = new int[k];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull())
            return false;

        if (!isEmpty()) {
            headIdx = (headIdx + myQueue.length - 1) % myQueue.length;
        }

        myQueue[headIdx] = value;
        len++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull())
            return false;

        if (!isEmpty()) {
            tailIdx = (tailIdx + 1) % myQueue.length;
        }

        myQueue[tailIdx] = value;
        len++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty())
            return false;

        if (len > 1)
            headIdx = (headIdx + 1) % myQueue.length;
        len--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty())
            return false;

        if (len > 1)
            tailIdx = (tailIdx + myQueue.length - 1) % myQueue.length;
        len--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty())
            return -1;

        return myQueue[headIdx];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty())
            return -1;

        return myQueue[tailIdx];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return len == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return len == myQueue.length;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertFront(3);
        myCircularDeque.insertFront(4);
    }
}
