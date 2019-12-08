package algorithm00405test.week1.job.done;


/**
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * <p>
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
 * <p>
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
 * <p>
 * 提示：
 * <p>
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_641_510 {
    private int[] obj;
    private int head;
    private int tail;
    int length = 0;
    int capacity;

    public static void main1(String[] args) {
        LeetCode_641_510 a = new LeetCode_641_510(3);
        boolean f = a.insertLast(1);
        f = a.insertLast(2);
        f = a.insertFront(3);
        f = a.insertFront(4);
        int b = a.getRear();
        f = a.isFull();
        f = a.deleteLast();
    }
    /** Initialize your data structure here. Set the size of the deque to be k. */
    /**
     * 构造函数,双端队列的大小为k
     *
     * @param k
     */
    public LeetCode_641_510(int k) {
        if (k < 1 || k > 1000) {
            throw new IllegalArgumentException("k 值为1～1000");
        }
        length = k;
        obj = new int[k];
        head = 0;
        tail = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    /**
     * 将一个元素添加到双端队列头部。 如果操作成功返回 true。
     *
     * @param value
     * @return
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (0 == head) {
            head = length - 1;
        } else {
            head--;
        }
        obj[head] = value;
        capacity++;
        return true;
    }


    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回 true。
     *
     * @param value
     * @return
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        obj[tail] = value;
        capacity++;
        if (length - 1 == tail) {
            tail = 0;
        } else {
            tail++;
        }

        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    /**
     * 从双端队列头部删除一个元素。 如果操作成功返回 true。
     *
     * @return
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        obj[head] = 0;
        head++;
        capacity--;
        if (head > length - 1) {
            head = 0;
        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回 true。
     *
     * @return
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (0 == tail){
            tail = length-1;
        } else {
            tail--;
        }
        obj[tail] = 0;
        capacity--;
        return true;
    }

    /** Get the front item from the deque. */
    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
     *
     * @return
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return obj[head];
    }

    /** Get the last item from the deque. */
    /**
     * 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
     *
     * @return
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        if (0 == tail){
            return obj[length-1];
        }
        return obj[tail-1];
    }

    /** Checks whether the circular deque is empty or not. */

    /**
     * 检查双端队列是否为空。
     *
     * @return
     */
    public boolean isEmpty() {
        return capacity == 0 ? true : false;
    }

    /** Checks whether the circular deque is full or not. */
    /**
     * 检查双端队列是否满了。
     *
     * @return
     */
    public boolean isFull() {
        return length == capacity ? true : false;
    }
}
