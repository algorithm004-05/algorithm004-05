package leetcode.editor.cn;
//设计实现双端队列。
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列

public class Leetcoce_641_480 {
    public static void main(String[] args) {
        //["MyCircularDeque","insertFront","deleteLast","isFull","insertFront","isFull","deleteFront",
        // "deleteFront","deleteLast","isEmpty","insertLast","deleteLast","deleteFront","insertLast",
        // "getRear","getRear","deleteLast","deleteFront","insertFront",
        // "deleteLast","getFront","getRear","getRear","getFront","insertLast","getFront","isEmpty","getFront","insertFront","insertFront","getRear","insertFront","insertLast","deleteFront","getRear","deleteLast","deleteFront","insertFront","getRear","insertLast","insertLast","getRear","getFront","insertLast","isFull","deleteFront","insertFront","getFront","getFront","getFront","isEmpty","insertLast","insertLast","getRear","getRear","getRear","getFront","getFront","getFront","isEmpty","deleteLast","deleteFront","deleteFront","getFront","insertLast","getFront","getFront","deleteLast","insertFront","insertFront","deleteLast","insertFront","isFull","getRear","isFull","isFull","getRear","getFront","getFront","insertFront","getFront","deleteFront","insertFront","getRear","insertFront","insertLast","insertFront","getFront","insertFront","insertLast","insertLast","getFront","insertFront","deleteLast","insertFront","insertFront","insertFront","insertFront","getFront","insertLast","getFront","deleteLast"]
        //[[84],[60],[],[],[80],[],[],[],[],[],[29],[],[],[6],[],[],[],[],[12],[],[],[],[],[],[85],[],[],[],[54],[7],[],[42],[37],[],[],[],[],[54],[],[8],[87],[],[],[49],[],[],[77],[],[],[],[],[57],[44],[],[],[],[],[],[],[],[],[],[],[],[51],[],[],[],[74],[76],[],[4],[],[],[],[],[],[],[],[61],[],[],[82],[],[11],[74],[85],[],[5],[7],[6],[],[98],[],[88],[93],[50],[35],[],[3],[],[]]

        MyCircularDeque circularDeque = new MyCircularDeque(84); // 设置容量大小为3
        assert circularDeque.insertFront(60);
        assert circularDeque.deleteLast();
        assert !circularDeque.isFull();
        assert circularDeque.insertFront(80);
        assert !circularDeque.isFull();
        assert circularDeque.deleteFront();
        assert !circularDeque.deleteFront();
        assert !circularDeque.deleteLast();
        assert circularDeque.isEmpty();
        assert circularDeque.insertLast(29);
        assert circularDeque.deleteLast();
        assert !circularDeque.deleteFront();
        assert circularDeque.insertLast(6);
        assert circularDeque.getRear() == 6;
        assert circularDeque.getRear() == 6;
        assert circularDeque.deleteLast();
        assert !circularDeque.deleteFront();
        assert circularDeque.insertFront(12);


    }


    //leetcode submit region begin(Prohibit modification and deletion)
    static class MyCircularDeque {
        //容量
        private int size;
        //当前的容量
        private int capacity;
        // 头元素
        private Node head;
        // 尾部元素
        private Node last;

        class Node {
            private Integer value;
            private Node next;
            private Node previous;

            public Node(Integer value) {
                this.value = value;
            }
        }

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.size = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (capacity + 1 > size) {
                //空间已经满了
                return false;
            }
            Node nodeInsert = new Node(value);
            nodeInsert.next = head;
            if (head != null) {
                head.previous = nodeInsert;
            }
            head = nodeInsert;
            if (capacity == 0) {
                last = head;
            }
            capacity++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (capacity + 1 > size) {
                //空间已经满了
                return false;
            }
            Node nodeInsert = new Node(value);
            if (last != null) {
                last.next = nodeInsert;
                nodeInsert.previous = last;
            }
            last = nodeInsert;
            if (capacity == 0) {
                head = last;
            }
            capacity++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (head == null) {
                return false;
            }
            head = head.next;
            capacity--;
            if (capacity == 0) {
                last = null;
            }
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (last == null) {
                return false;
            }
            Node previous = last.previous;
            if (previous != null) {
                previous.next = null;
            }
            last = previous;
            if (last == null) {
                head = null;
            }
            capacity--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (head == null) {
                return -1;
            }
            return head.value;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (last == null) {
                return -1;
            }
            return last.value;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return capacity == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return capacity >= size;
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
//leetcode submit region end(Prohibit modification and deletion)

}