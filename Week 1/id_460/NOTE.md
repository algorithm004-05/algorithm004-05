# NOTE
PriorityQueue源码学习分析
1.PriorityQueue简介

PriorityQueue是一个优先队列，和传统的队列相比，它不是先进先出，会根据优先级来决定哪个元素出队列，它也是Collecion中的一个，所以他也提供了迭代器用来迭代。
PriorityQueue底层的数据结构是堆，用堆的好处是，每次入队和出队后，调整堆的时间复杂度为log（n）。

2.PriorityQueue的数据结构
PriorityQueue的数据结构其实就是数组，不过这个数组的逻辑结构是一棵完全二叉树.

从结构图中可以发现，广度遍历这棵树和数组遍历是一样的结果，一个节点n的左儿子和右儿子为2n+1和2n+2。
3.PriorityQueue重要的方法
PriorityQueue关键的地方在于以下三点：

建立优先队列
入队
出队
建立优先队列：
建立空的优先队列的就不用说了吧
给一个集合，进行初始化，这里会分为以下三种情况：
public PriorityQueue(Collection<? extends E> c) {
    // a.有序的情况
    if (c instanceof SortedSet<?>) {
        SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
        this.comparator = (Comparator<? super E>) ss.comparator();
        initElementsFromCollection(ss);
    }
    // b.是PriorityQueue或者它的子类
    else if (c instanceof PriorityQueue<?>) {
        PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
        this.comparator = (Comparator<? super E>) pq.comparator();
        initFromPriorityQueue(pq);
    }
    // c.无序的情况
    else {
        this.comparator = null;
        initFromCollection(c);
    }
}
a.在有序的情况，元素n一定比元素2n+1和元素2n+2大（或者小），直接复制原来的数组的就行了：

private void initElementsFromCollection(Collection<? extends E> c) {
    Object[] a = c.toArray();
    // If c.toArray incorrectly doesn't return Object[], copy it.
    if (a.getClass() != Object[].class)
        a = Arrays.copyOf(a, a.length, Object[].class);
    int len = a.length;
    if (len == 1 || this.comparator != null)
        for (int i = 0; i < len; i++)
            if (a[i] == null)
                throw new NullPointerException();
    this.queue = a;
    this.size = a.length;
}
b.是PriorityQueue或者它的子类

private void initFromPriorityQueue(PriorityQueue<? extends E> c) {
    if (c.getClass() == PriorityQueue.class) {
        // 如果是PriorityQueue的实例
        this.queue = c.toArray();
        this.size = c.size();
    } else {
        // 可能子类的结构和父类会有变化，所以和无序的处理方式一样
        initFromCollection(c);
    }
}
c.无序的情况，先复制数组，然后调整堆

private void initFromCollection(Collection<? extends E> c) {
    // 初始化数组
    initElementsFromCollection(c);
    // 调整堆
    heapify();
}
调整堆

private void heapify() {
    // 从最后一个不为叶子节点的节点开始
    for (int i = (size >>> 1) - 1; i >= 0; i--)
        siftDown(i, (E) queue[i]);
}
选择比较方式

private void siftDown(int k, E x) {
    if (comparator != null)
        siftDownUsingComparator(k, x);//使用比较器
    else
        siftDownComparable(k, x);//元素本身支持比较
}
上面两种方式类似，挑siftDownUsingComparator进行解读一下

private void siftDownUsingComparator(int k, E x) {
    // half是第一个叶子节点的位置
    int half = size >>> 1;
    //如果小于half，则为非叶子节点，需要进行调整
    while (k < half) {
        // 左儿子
        int child = (k << 1) + 1;
        Object c = queue[child];
        //右儿子
        int right = child + 1;
        //左儿子和右儿子比较，取优先级最高的
        if (right < size &&
            comparator.compare((E) c, (E) queue[right]) > 0)
            c = queue[child = right];
        //和当前 节点比较，如果当前节点优先级最高，则不需要继续调整了
        if (comparator.compare(x, (E) c) <= 0)
            break;
        // 将当前节点和优先级最高的节点进行交换，继续循环
        queue[k] = c;
        k = child;
    }
    queue[k] = x;
}
入队：
public boolean add(E e) {
    return offer(e);
}
public boolean offer(E e) {
    // 从这里可以知道，PriorityQueue不支持null
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        grow(i + 1);//扩容
    //实际大小加1
    size = i + 1;
    if (i == 0)
        queue[0] = e;// 堆顶直接赋值
    else
        siftUp(i, e);// 在最后的位置插入元素，进行调整堆
    return true;
}
调整堆

private void siftUp(int k, E x) {
    if (comparator != null)
        siftUpUsingComparator(k, x);//使用比较器
    else
        siftUpComparable(k, x);//元素本身支持比较
}
\color{red}{注意：这个调整堆是向上调整，建立堆的时候是向下调整}
同样的随便挑一个来分析，这次使用元素本身进行比较吧

private void siftUpComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>) x;
    //循环进行调整
    while (k > 0) {
        //获取父节点
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        //如果小于父节点优先级，则停止调整
        if (key.compareTo((E) e) >= 0)
            break;
        //交换该节点和父节点，继续调整
        queue[k] = e;
        k = parent;
    }
    queue[k] = key;
}
出队：
出队挺简单的，只需要将第一个元素和最后一个元素进行交换，删除最后一个元素，然后从堆顶向下调整堆就好

public E poll() {
    if (size == 0)
        return null;
    int s = --size;
    modCount++;
    //记录第一个元素
    E result = (E) queue[0];
    //记录最后一个元素
    E x = (E) queue[s];
    //将最后一个元素置空
    queue[s] = null;
    if (s != 0)
        siftDown(0, x);// 向下调整堆
    return result;
}
4.堆排序
了解了优先队列，再去实现堆排序就简单了，只需要将堆顶元素和最后一个元素n进行置换，然后对1至n-1元素进行调整，然后再将堆顶元素和最后一个元素n-1进行置换，对1至n-2元素进行调整，以此类推，就可以完成排序。


  

