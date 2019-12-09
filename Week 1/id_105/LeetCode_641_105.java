class MyCircularDeque {

    private static class Node{
        int value ;
        Node prev;
        Node next ;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private int length;

    private int capacity;

    private Node head;

    private Node tail;


    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.length = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (length < capacity) {
            Node newHead = new Node(value);
            if (head == null){
                this.head = newHead;
                this.tail = newHead;
            }else{
                Node oldHead = this.head;
                oldHead.prev = newHead;
                newHead.next = oldHead;
                this.head = newHead;
            }
            length++;
            return true;
        }
        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (length < capacity) {
            Node newTail = new Node(value);
            if (this.tail == null){
                this.tail = newTail;
                this.head = newTail;
            }else{
                Node oldTail = this.tail;
                oldTail.next = newTail;
                newTail.prev = oldTail;
                this.tail = newTail;
            }
            length++;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (length > 0) {
            Node newHead = this.head.next;
            if (newHead != null){
                newHead.prev = null;
            }
            if(this.head != null)this.head.next = null;
            this.head = newHead;
            length--;
            if (length <= 1) this.tail = this.head;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (length > 0) {
            Node newTail = this.tail.prev;
            if (newTail != null)newTail.next = null;
            if(this.tail != null)this.tail.prev = null;
            this.tail = newTail;
            length--;
            if (length <= 1) this.head = this.tail;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return this.head == null ? -1 : this.head.value;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return this.tail == null ? -1 : this.tail.value;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return this.head == null || length == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return length >= capacity;
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