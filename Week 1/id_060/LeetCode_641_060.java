/*
  641
  Design your implementation of the circular double-ended queue (deque).

  Your implementation should support following operations:
    MyCircularDeque(k): Constructor, set the size of the deque to be k.
    insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
    insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
    deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
    deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
    getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
    getRear(): Gets the last item from Deque. If the deque is empty, return -1.
    isEmpty(): Checks whether Deque is empty or not. 
    isFull(): Checks whether Deque is full or not.
     
  Example:
    MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
    circularDeque.insertLast(1);			// return true
    circularDeque.insertLast(2);			// return true
    circularDeque.insertFront(3);			// return true
    circularDeque.insertFront(4);			// return false, the queue is full
    circularDeque.getRear();  			// return 2
    circularDeque.isFull();				// return true
    circularDeque.deleteLast();			// return true
    circularDeque.insertFront(4);			// return true
    circularDeque.getFront();			// return 4
     

  Note:
    All values will be in the range of [0, 1000].
    The number of operations will be in the range of [1, 1000].
    Please do not use the built-in Deque library.
*/

public class DesignCircularDeque {

  int[] myqueue;
  int front;      //队头指针
  int rear;       //队尾指针
  int size;       //队列当前的大小
  int capacity;   //队列的容量

  /**
   * Initialize your data structure here. Set the size of the deque to be k.
   */
  public DesignCircularDeque(int k) {
    this.myqueue = new int[k];
    this.front = 0;
    this.rear = 0;
    this.size = 0;
    this.capacity = k;
  }

  /**
   * Adds an item at the front of Deque. Return true if the operation is successful.
   */
  public boolean insertFront(int value) {
    if (rear == front && size == capacity) {
      return false;
    } else {
      front = (front + capacity - 1) % capacity;
      myqueue[front] = value;
      size++;
      return true;
    }
  }

  /**
   * Adds an item at the rear of Deque. Return true if the operation is successful.
   */
  public boolean insertLast(int value) {
    if (rear == front && size == capacity) {
      return false;
    } else {
      myqueue[rear] = value;
      rear = (rear + 1 + capacity) % capacity;
      size++;
      return true;
    }

  }

  /**
   * Deletes an item from the front of Deque. Return true if the operation is successful.
   */
  public boolean deleteFront() {
    if (rear == front && size == 0) {
      return false;
    } else {
      front = (front + 1) % capacity;
      size--;
      return true;
    }

  }

  /**
   * Deletes an item from the rear of Deque. Return true if the operation is successful.
   */
  public boolean deleteLast() {
    if (rear == front && size == 0) {
      return false;
    } else {
      rear = (rear - 1 + capacity) % capacity;
      size--;
      return true;
    }

  }

  /**
   * Get the front item from the deque.
   */
  public int getFront() {
    if ((rear == front) && size == 0) {
      return -1;
    } else {
      return myqueue[front];
    }
  }

  /**
   * Get the last item from the deque.
   */
  public int getRear() {
    if ((rear == front) && size == 0) {
      return -1;
    } else {
      return myqueue[(rear - 1 + capacity) % capacity];
    }

  }

  /**
   * Checks whether the circular deque is empty or not.
   */
  public boolean isEmpty() {
    return (rear == front) && size == 0;
  }

  /**
   * Checks whether the circular deque is full or not.
   */
  public boolean isFull() {
    return rear == front && size == capacity;

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
}
