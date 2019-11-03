package Question641CircluarDeque;

public class MyCircularDeque {
    //队列的内部使用数组来实现，带有两个指针head和tail来指向数组的区间段。
    public int head;
    public int tail;
    public int maxSize;
    public int size;
    public int[] list;

    public MyCircularDeque() {
        head = tail = size = 0;
        maxSize = 1000;
        list = new int[maxSize];
    }
    /**
     * 取模运算
     * */
    private int getMod(int logicIndex){
        int innerArrayLength = this.list.length;

        //:::由于队列下标逻辑上是循环的

        //:::当逻辑下标小于零时
        if(logicIndex < 0){
            //:::加上当前数组长度
            logicIndex += innerArrayLength;
        }
        //:::当逻辑下标大于数组长度时
        if(logicIndex >= innerArrayLength){
            //:::减去当前数组长度
            logicIndex -= innerArrayLength;
        }

        //:::获得真实下标
        return logicIndex;
    }
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this();
        size = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
      this.head = getMod(this.head-1);
      this.list[this.head]=value;
      if (head==tail){
          expand();
      }
      return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        this.list[this.tail]=value;
        this.tail = getMod(this.tail+1);
        if (head==tail){
            expand();
        }
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        this.list[this.head] = -1;
        this.head = getMod(this.head+1);
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        this.list[this.tail] = -1;
        this.tail = getMod(this.tail-1);
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
         return this.list[this.head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return this.list[this.tail];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return list.length==0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return list.length==maxSize;
    }
    private static final int EXPAND_BASE =2;
    /**
     * 内部数组扩容
     * */
    private void expand(){
        //:::内部数组 扩容两倍
        int elementsLength = this.list .length;
        int[] newElements = new int[elementsLength * EXPAND_BASE];

        //:::将"head -> 数组尾部"的元素 复制在新数组的前面 (tips：使用System.arraycopy效率更高)
        for(int i=this.head, j=0; i<elementsLength; i++,j++){
            newElements[j] = this.list[i];
        }

        //:::将"0 -> head"的元素 复制在新数组的后面 (tips：使用System.arraycopy效率更高)
        for(int i=0, j=elementsLength-this.head; i<this.head; i++,j++){
            newElements[j] = this.list[i];
        }

        //:::初始化head,tail下标
        this.head = 0;
        this.tail = this.list.length;

        //:::内部数组指向 新扩容的数组
        this.list = newElements;
    }
}
