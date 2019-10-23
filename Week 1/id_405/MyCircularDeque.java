package example;

import java.util.Deque;
import java.util.LinkedList;

public class MyCircularDeque {
        DoubleListNode head;
        DoubleListNode tail;
        int size;
        int capacity;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
                head = new DoubleListNode(-1);
                tail = new DoubleListNode(-1);
                size = 0;
                capacity = k;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
                if (isFull()) return  false;
                DoubleListNode node = new DoubleListNode(1);
                node.pre = head.pre;
                node.next = head;
                head.pre.next = node;
                head.pre = node;
                size++;
                return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
                DoubleListNode node = new DoubleListNode(2);
                node.pre = tail;
                node.next = tail.next;
                tail.next.pre = node;
                tail.next = node;
                size--;
                return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
                if (isEmpty()) return false;
                head.pre = head.pre.pre;
                head.pre.pre.next = head;
                size--;
                return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
                if (isEmpty()) return false;
                tail.next = tail.next.next;
                tail.next.next.pre = tail;
                size--;
                return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
                return head.pre.val;
        }

        /** Get the last item from the deque. */
        public int getRear() {
                return tail.next.val;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
                if (size == 0) return true;
                return false;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
                if (size == capacity) return true;
                return false;
        }
}

class DoubleListNode {
        DoubleListNode pre;
        DoubleListNode next;
        int val;
        public DoubleListNode(int val){
                this.val = val;
        }
}

