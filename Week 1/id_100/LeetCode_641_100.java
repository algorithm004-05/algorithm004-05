import java.util.Stack;
/**
 *  https://leetcode-cn.com/problems/design-circular-deque
 */
public class LeetCode_641_100 {
    //下面分别使用数组，单链表以及栈实现了双端队列
}



/**
 * 使用数组实现双端队列
 * insertFront与insertLast插入元素时，最坏时间复杂度为O(n)
 * deleteFront与deleteLast时间复杂度为O(1)
 * getFront与getRear时间复杂度为O(1)
 */
class MyCircularDeque {

    private int[] array;
    private int headIndex;
    private int tailIndex;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        array = new int[k];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isEmpty()) {
            headIndex = tailIndex = 0;
            array[headIndex] = value;
            size++;
            return true;
        }
        if (!isFull()) {
            if (headIndex == 0) {
                for (int i = tailIndex; i >= 0; i--) {
                    array[i + 1] = array[i];
                }
                tailIndex++;
                array[headIndex] = value;
            } else {
                array[--headIndex] = value;
            }
            size++;
            return true;
        }
        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isEmpty()) {
            headIndex = tailIndex = array.length - 1;
            array[tailIndex] = value;
            size++;
            return true;
        }
        if (!isFull()) {

            if (tailIndex == array.length - 1) {
                for (int i = headIndex; i < array.length; i++) {
                    array[i - 1] = array[i];
                }
                headIndex--;
                array[array.length - 1] = value;
            } else {
                array[++tailIndex] = value;
            }
            size++;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (!isEmpty()) {
            headIndex++;
            size--;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (!isEmpty()) {
            tailIndex--;
            size--;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (!isEmpty()) {
            return array[headIndex];
        }
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (!isEmpty()) {
            return array[tailIndex];
        }
        return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == array.length;
    }
}



/**
 * 使用单链表实现双端队列
 * insertFront与insertLast插入元素时，时间复杂度为O(1)
 * deleteFront时间复杂度为O(1),
 * deleteLast需要找到tail结点的pre结点，且tail结点最后要置于pre节点上，需要遍历整个链表，所以时间复杂度为O(n)
 * getFront与getRear时间复杂度为O(1)
 */
class MyCircularDeque2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private int capacity;
    private ListNode sentinel;
    private ListNode tail;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque2(int k) {
        this.capacity = k;
        sentinel = new ListNode(-1);
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (!isFull()) {
            ListNode insertNode = new ListNode(value);
            if (isEmpty()) {
                tail = insertNode;
            }
            insertNode.next = sentinel.next;
            sentinel.next = insertNode;
            size++;
            return true;
        }
        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (!isFull()) {
            ListNode insertNode = new ListNode(value);
            if (isEmpty()) {
                sentinel.next = insertNode;
                tail = insertNode;
            } else {
                tail.next = insertNode;
                tail = insertNode;
            }
            size++;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (!isEmpty()) {
            sentinel.next = sentinel.next.next;
            size--;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (!isEmpty()) {
            ListNode pre = sentinel;
            ListNode del = sentinel.next;
            while (del.next != null) {
                pre = pre.next;
                del = del.next;
            }
            pre.next = null;
            tail = pre;
            size--;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (!isEmpty()) {
            return sentinel.next.val;
        }
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (!isEmpty()) {
            return tail.val;
        }
        return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return sentinel.next == null;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }
}


/**
 * 使用两个栈来实现
 * |  |            |  |
 * |  |            |  |
 * |  |            |  |
 * |  |            |  |
 * ---             ---
 * headStack      tailSack
 * insertFront和insertLast时间复杂度为O(1)
 * deleteFront和deleteLast最坏的时间复杂度为O(n)
 * getFront和getRear最坏的时间复杂度为O(n)
 */
class MyCircularDeque3 {

    private int capacity;
    private int size;
    private Stack<Integer> headStack;
    private Stack<Integer> tailStack;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque3(int k) {
        headStack = new Stack<>();
        tailStack = new Stack<>();
        this.capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (!isFull()) {
            headStack.push(value);
            size++;
            return true;
        }
        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (!isFull()) {
            tailStack.push(value);
            size++;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (!isEmpty()) {
            if (headStack.empty()) {
                while (!tailStack.empty()) {
                    headStack.push(tailStack.pop());
                }
            }
            headStack.pop();
            size--;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (!isEmpty()) {
            if (tailStack.empty()) {
                while (!headStack.empty()) {
                    tailStack.push(headStack.pop());
                }
            }
            tailStack.pop();
            size--;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (!isEmpty()) {
            if (headStack.empty()) {
                while (!tailStack.empty()) {
                    headStack.push(tailStack.pop());
                }
            }
            return headStack.peek();
        }
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (!isEmpty()) {
            if (tailStack.empty()) {
                while (!headStack.empty()) {
                    tailStack.push(headStack.pop());
                }
            }
            return tailStack.peek();
        }
        return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return capacity == size;
    }
}


