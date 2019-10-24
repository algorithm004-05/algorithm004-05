@[toc]

Java API 地址：
[https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/PriorityQueue.html](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/PriorityQueue.html)

jdk源码下载地址
[https://gitee.com/huangtianyu/jdk-source](https://gitee.com/huangtianyu/jdk-source)

参考：
[https://www.cnblogs.com/wangziqiang123/p/11697080.html](https://www.cnblogs.com/wangziqiang123/p/11697080.html)

[https://blog.csdn.net/qq_41786692/article/details/80302254](https://blog.csdn.net/qq_41786692/article/details/80302254)

[https://www.jianshu.com/p/dc0eeb82e994](https://www.jianshu.com/p/dc0eeb82e994)


Queue（队列）是拥有先进先出（FIFO）特性的数据结构，PriorityQueue（优先级队列）是它的子类之一，不同于先进先出，它可以通过比较器控制元素的输出顺序（优先级）。

# 类继承关系

API文档中给出了继承关系，如下图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019102019493379.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hvbmd4dWU4ODg4,size_16,color_FFFFFF,t_70)

## Queue
先来看Queue接口：

```java
public interface Queue<E> extends Collection<E>
```
Queue接口继承了Collection接口，表示集合。它提供了三种方法，即：增加、删除、获取，每种都有两个实现。

```java
// 增加元素
boolean add(E e);
boolean offer(E e);
// 删除元素
E remove();
E poll();
// 获取元素
E element();
E peek();
```


## AbstractQueue

```java
public abstract class AbstractQueue<E>
    extends AbstractCollection<E>
    implements Queue<E> {
```
AbstractQueue继承了AbstractCollection类和实现了Queue接口。既然是模板类那肯定有模板方法。AbstractQueue源码中实现了add、remove和elemet方法。
```java
public boolean add(E e) {
        if (offer(e)) // 调用offer
        ...
    }
    
public E remove() {
        E x = poll(); // 调用poll
        ...
    }
    
public E element() {
        E x = peek(); // 调用peek
        ...
    }
```


# PriorityQueue源码分析
PriorityQueue是通过“极大优先级堆”实现的，即堆顶元素是优先级最大的元素。算是集成了大根堆和小根堆的功能。


根据堆的特性，存储结构肯定是数组了；既然支持不同优先级，肯定有比较器，也就是说支持自定义排序和顺序排序。

```java
   private final Comparator<? super E> comparator;
```

## grow方法
PriorityQueue是支持扩容的，先来看扩容方法：
```java
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }
```
每次扩展的容量大小还是挺大的，要么变为原来的双倍，要么增长一半大小。

在看增加元素、删除元素和获取元素的方法之前，先了解以下几点：

- 完全二叉树的最后一个非叶子结点的下标是 (n-2) / 2；
- 完全二叉树中如果一个非叶子结点的下标是i，则它的父结点下标是（i-1）/2，它的左孩子下标是 2 * i + 1，右孩子下标是 2 * i + 2；

## offer方法

```java
   public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1); // 如果超出当前容量，则进行扩容
        siftUp(i, e); // 新元素都是增加在数组尾部，然后进行上移操作，即构建堆
        size = i + 1; // 当前大小加1
        return true;
    }
```
siftUp方法最终会调用siftUpUsingComparator或者siftUpComparable方法，两个实现类似，这里直接看siftUpUsingComparator方法。

```java
// 上移就是不断和父结点比较
private static <T> void siftUpUsingComparator(
        int k, T x, Object[] es, Comparator<? super T> cmp) {
        while (k > 0) {
            int parent = (k - 1) >>> 1; // 父结点下标
            Object e = es[parent];
            if (cmp.compare(x, (T) e) >= 0) // 优先级高则继续上移比较
                break;
            es[k] = e;
            k = parent;
        }
        es[k] = x;
    }
```
每次增加元素，都要保证堆序。
## poll方法

```java
public E poll() {
        final Object[] es;
        final E result;
        // 返回堆顶元素
        if ((result = (E) ((es = queue)[0])) != null) {
            modCount++;
            final int n;
            final E x = (E) es[(n = --size)]; // 把尾部元素换到第一个
            es[n] = null;
            if (n > 0) {
                final Comparator<? super E> cmp;
                if ((cmp = comparator) == null) // 自然序时，下移调整
                    siftDownComparable(0, x, es, n);
                else // 自定义序下移调整
                    siftDownUsingComparator(0, x, es, n, cmp);
            }
        }
        return result;
    }
```
poll方法会返回队首元素（堆顶），并将元素从堆中删除。删除过程，是将第一个元素与最后一个元素进行替换，然后再进行下移调整操作。

## remove方法
poll方法可以看出是remove方法的特例，即固定删除第一个元素。

```java
public boolean remove(Object o) {
        int i = indexOf(o); // 找到待删除元素位置
        if (i == -1)
            return false;
        else {
            removeAt(i); // 删除指定位置元素
            return true;
        }
    }
```
调用了removeAt方法：

```java
E removeAt(int i) {
        // assert i >= 0 && i < size;
        final Object[] es = queue;
        modCount++;
        int s = --size; // size已经减1
        if (s == i) // removed last element
            es[i] = null; // 已经删除到最后一个元素
        else {
            E moved = (E) es[s]; // 尾元素
            es[s] = null;
            siftDown(i, moved); // 指定元素换尾元素，然后调整
            if (es[i] == moved) {
                siftUp(i, moved); // 如果指定位置换成了尾元素（没有发生下移）则进行上移操作
                if (es[i] != moved)
                    return moved;
            }
        }
        return null; // 正常删除时返回null
    }
```

# 总结
1. PriorityQueue是基于最大优先级堆实现的，根据比较器的情况可以是大根堆或者小根堆；
2. PriorityQueue不支持null；
3. PriorityQueue不是线程安全的，多线程环境下可以使用`java.util.concurrent.PriorityBlockingQueue`；
4. 使用iterator()遍历时，不保证输出的序列是有序的，其实遍历的是存储数组。