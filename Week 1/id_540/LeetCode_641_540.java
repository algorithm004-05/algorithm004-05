package com.company;

public class LeetCode_641_540 {
    class MyCircularDeque {

        private int[] a;
        private int head;
        private int tail;
        private int capacity;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            a = new int[k];
            head = 0;
            tail = 0;
            capacity = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (!insertionCheck(value)) {
                return false;
            }
            head = indexBefore(head);
            a[head] = value;
            capacity++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (!insertionCheck(value)) {
                return false;
            }
            a[tail] = value;
            tail = indexAfter(tail);
            capacity++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (!deletionCheck()) {
                return false;
            }

            head = indexAfter(head);
            capacity--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (!deletionCheck()) {
                return false;
            }

            tail = indexBefore(tail);
            capacity--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return a[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return a[indexBefore(tail)];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return head == tail && capacity == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return  head == tail && capacity == a.length;
        }

        private boolean insertionCheck(int value) {
            if (isFull()) {
                System.out.println("Deque is full. " + value + " cannot be inserted.");
                return false;
            }
            return true;
        }

        private boolean deletionCheck() {
            if (isEmpty()) {
                System.out.println("Deque is empty. Value cannot be deleted.");
                return false;
            }
            return true;
        }

        private int indexBefore(int p) {
            if (p == 0) {
                return a.length - 1;
            } else {
                return p - 1;
            }
        }

        private int indexAfter(int p) {
            if (p == a.length - 1) {
                return 0;
            } else {
                return p + 1;
            }
        }
    }
}


