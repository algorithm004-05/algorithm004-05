/**
* @author leetcode
* FIXME: 这里的rear是什么作用?
* 没看懂
*/
class LeetCode_641_495 {

    int[] a;
    int front, rear, cap;

    public static void main(String[] args) {
      CircularDeque deque = new CircularDeque(4);
      System.out.println(deque.insertFront(1));
      System.out.println(deque.insertLast(3));
      System.out.println(deque.insertFront(2));
      System.out.println(deque.insertLast(4));
      System.out.println(deque.insertFront(5));
      System.out.println(deque.insertFront(6));
      System.out.println(deque.getFront());
      System.out.println(deque.getRear());
      System.out.println(deque.getFront());
      System.out.println(deque.getRear());
      System.out.println(deque.deleteLast());
      System.out.println(deque.deleteFront());
      System.out.println(deque.getFront());
      System.out.println(deque.getRear());
      System.out.println(deque.deleteLast());
      System.out.println(deque.deleteFront());
      System.out.println(deque.getFront());
      System.out.println(deque.getRear());
      System.out.println(deque.deleteLast());
      System.out.println(deque.deleteFront());
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public CircularDeque(int k) {
        a = new int[k + 1];
        front = 0;
        rear = 0;
        cap = k + 1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        a[front] = value;
        front = (front + 1) % cap;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        rear = (rear - 1 + cap) % cap;
        a[rear] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (front - 1 + cap) % cap;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = (rear + 1) % cap;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : a[(front - 1 + cap) % cap];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : a[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
         return (front + 1) % cap == rear;
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
