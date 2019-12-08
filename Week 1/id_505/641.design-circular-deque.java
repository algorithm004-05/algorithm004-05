import java.lang.annotation.Retention;

import sun.print.resources.serviceui;

/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 *
 * https://leetcode.com/problems/design-circular-deque/description/
 *
 * algorithms
 * Medium (49.99%)
 * Likes:    134
 * Dislikes: 30
 * Total Accepted:    9.7K
 * Total Submissions: 19.5K
 * Testcase Example:  '["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]\n[[3],[1],[2],[3],[4],[],[],[],[4],[]]'
 *
 * Design your implementation of the circular double-ended queue (deque).
 * 
 * Your implementation should support following operations:
 * 
 * 
 * MyCircularDeque(k): Constructor, set the size of the deque to be k.
 * insertFront(): Adds an item at the front of Deque. Return true if the
 * operation is successful.
 * insertLast(): Adds an item at the rear of Deque. Return true if the
 * operation is successful.
 * deleteFront(): Deletes an item from the front of Deque. Return true if the
 * operation is successful.
 * deleteLast(): Deletes an item from the rear of Deque. Return true if the
 * operation is successful.
 * getFront(): Gets the front item from the Deque. If the deque is empty,
 * return -1.
 * getRear(): Gets the last item from Deque. If the deque is empty, return
 * -1.
 * isEmpty(): Checks whether Deque is empty or not. 
 * isFull(): Checks whether Deque is full or not.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to
 * be 3
 * circularDeque.insertLast(1);            // return true
 * circularDeque.insertLast(2);            // return true
 * circularDeque.insertFront(3);            // return true
 * circularDeque.insertFront(4);            // return false, the queue is full
 * circularDeque.getRear();              // return 2
 * circularDeque.isFull();                // return true
 * circularDeque.deleteLast();            // return true
 * circularDeque.insertFront(4);            // return true
 * circularDeque.getFront();            // return 4
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Deque library.
 * 
 * 
 */

// @lc code=start
class MyCircularDeque {
    
    private int front;
    private int rear;
    private int capbility;
    private int size;
    private int[] array;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.array = new int[k];
        this.rear = 0;
        this.front = 0;
        this.size = 0;
        this.capbility = k;
    }

    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        if ( this.isFull()) {
            return false;
        }

        
        front = (front + capbility -1) % capbility;
        this.array[front] = value;
        this.size++;
        
        return true;
    }

    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        
        
        if (this.isFull()){ return false; }

        this.array[rear] = value;
        rear = (rear+1) % capbility;
        
        this.size++;

        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if( this.isEmpty() ) {
            return false;
        }
        
        front = (front + 1) % capbility;
        this.size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        
        if ( this.isEmpty() ){
            return false;
        }

        rear = (rear + capbility - 1) % capbility;
        this.size--;

        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if ( this.isEmpty() ){
            return -1;
        }
        return this.array[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if ( this.isEmpty()){
            return -1;
        }
        return this.array[(rear + capbility -1) % capbility];
        
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.size == this.capbility;
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
// @lc code=end

