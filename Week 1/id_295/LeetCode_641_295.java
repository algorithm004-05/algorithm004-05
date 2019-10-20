public class DesignCircularDeque {
//    1. Using Array
    class MyCircularDeque {

        int[] deque;
        int head, tail, k;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularDeque(int k) {
            deque = new int[k + 1];
            head = 0;
            tail = 0;
            this.k = k + 1;
        }

        private int next(int id) {
            return (id + 1) % k;
        }

        private int pre(int id) {
            return (id - 1 + k) % k;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(isFull()) return false;
            deque[head] = value;
            head = next(head);
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(isFull()) return false;
            tail = pre(tail);
            deque[tail] = value;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(isEmpty()) return false;
            head = pre(head);
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(isEmpty()) return false;
            tail = next(tail);
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int getFront() {
            return isEmpty() ? -1 : deque[pre(head)];
        }

        /**
         * Get the last item from the queue.
         */
        public int getRear() {
            return isEmpty() ? -1 : deque[tail];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return head == tail;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return tail == next(head);
        }
    }

//    2. Using LinkedList
//    class DoubleListNode {
//        DoubleListNode pre;
//        DoubleListNode next;
//        int val;
//
//        public DoubleListNode(int val) {
//            this.val = val;
//        }
//    }
//
//    class MyCircularDeque {
//        int size;
//        int k;
//        DoubleListNode head;
//        DoubleListNode tail;
//
//        /**
//         * Initialize your data structure here. Set the size of the deque to be k.
//         */
//        public MyCircularDeque(int k) {
//            head = new DoubleListNode(-1);
//            tail = new DoubleListNode(-1);
//            head.pre = tail;
//            tail.next = head;
//            this.k = k;
//            this.size = 0;
//        }
//
//        /**
//         * Adds an item at the front of Deque. Return true if the operation is successful.
//         */
//        public boolean insertFront(int value) {
//            if (size == k)
//                return false;
//            DoubleListNode node = new DoubleListNode(value);
//            node.next = head;
//            node.pre = head.pre;
//            head.pre.next = node;
//            head.pre = node;
//            size++;
//            return true;
//        }
//
//        /**
//         * Adds an item at the rear of Deque. Return true if the operation is successful.
//         */
//        public boolean insertLast(int value) {
//            if (size == k)
//                return false;
//            DoubleListNode node = new DoubleListNode(value);
//            node.next = tail.next;
//            tail.next.pre = node;
//            tail.next = node;
//            node.pre = tail;
//            size++;
//            return true;
//        }
//
//        /**
//         * Deletes an item from the front of Deque. Return true if the operation is successful.
//         */
//        public boolean deleteFront() {
//            if (size == 0)
//                return false;
//            head.pre.pre.next = head;
//            head.pre = head.pre.pre;
//            size--;
//            return true;
//        }
//
//        /**
//         * Deletes an item from the rear of Deque. Return true if the operation is successful.
//         */
//        public boolean deleteLast() {
//            if (size == 0)
//                return false;
//            tail.next.next.pre = tail;
//            tail.next = tail.next.next;
//            size--;
//            return true;
//        }
//
//        /**
//         * Get the front item from the deque.
//         */
//        public int getFront() {
//            return head.pre.val;
//        }
//
//        /**
//         * Get the last item from the deque.
//         */
//        public int getRear() {
//            return tail.next.val;
//        }
//
//        /**
//         * Checks whether the circular deque is empty or not.
//         */
//        public boolean isEmpty() {
//            return size == 0;
//        }
//
//        /**
//         * Checks whether the circular deque is full or not.
//         */
//        public boolean isFull() {
//            return size == k;
//        }
//    }

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
