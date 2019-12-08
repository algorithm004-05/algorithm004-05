package com.geek.lee.leetcode.medium;

/**
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *  
 *  
 *
 * 提示：
 *
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 641. 设计循环双端队列
 *
 */
public class MyCircularDeque641 {

}

class MyCircularDeque {

    /**
     * 队列使用容量
     */
    private int capacity = 0;

    /**
     * 队列大小
     */
    private static int size;

    /**
     * 队列头
     */
    private Node head;

    /**
     * 队列尾
     */
    private Node tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.size = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (this.capacity == this.size) {
            return false;
        }

        Node insertHead = new Node(value);
        insertHead.next = head;
        if (head != null) {
            head.previous = insertHead;
        }
        head = insertHead;
        if (capacity == 0) {
            tail = head;
        }
        capacity ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.capacity == this.size) {
            return false;
        }
        Node insertTail = new Node(value);
        if (tail != null) {
            tail.next = insertTail;
            insertTail.previous = tail;
        }
        tail = insertTail;
        if (capacity == 0) {
            head = tail;
        }

        capacity ++;

        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (capacity == 0) {
            return false;
        }
        if (head == null) {
            return false;
        }
        if (head.next != null) {

            head = head.next;
            head.previous = null;
        }
        else {
            head = null;
            tail = null;
        }

        capacity --;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (capacity == 0) {
            return false;
        }
        if (null == tail) {
            return false;
        }
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        }
        if (tail == null) {
            head = null;
        }
        capacity --;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (capacity == 0 || head == null) {
            return -1;
        }
        return head.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (capacity == 0 || tail == null) {
            return -1;
        }
        return tail.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return capacity <= 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return capacity >= size;
    }

    class Node {
        private Integer value;
        private Node next;
        private Node previous;

        public Node(Integer value) {
            this.value = value;
        }
    }
}
