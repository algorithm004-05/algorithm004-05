## 作业一: 用add first或add last这套新的API改写Deque的代码

```java
public class OldDemo {

  public static void main(String[] args) {
    Deque<String> deque = new LinkedList<String>();

    deque.push("a");
    deque.push("b");
    deque.push("c");
    System.out.println(deque);

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while(deque.size() > 0) {
      // 这里如果LinkedList为空，会抛出NoSuchElementException异常
      System.out.println(deque.pop());
    }
    System.out.println(deque);
  }
}
```

```java
public class NewLinkedListDemo {

  public static void main(String[] args) {
    // LinkedList没有指定并固定容量的构造方法
    Deque<String> deque = new LinkedList<String>();

    // 如果可以立即执行此操作，而不会违反容量限制，则在此双端队列的前面插入指定的元素；
    // 如果当前没有可用空间，则抛出IllegalStateException
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addFirst("c");
    deque.addLast("d");
    // 这里插入成功会返回true
    boolean result = deque.offerFirst("e");
    System.out.println(deque);

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while(deque.size() > 0) {
      // 这里如果LinkedList为空，会返回null
      System.out.println(deque.pollFirst());
    }
    System.out.println(deque);
  }
}
```

```java
public class NewLinkedBlockingDequeDemo {

  public static void main(String[] args) {

    // 这里指定容器的固定容量为3
    Deque<String> deque = new LinkedBlockingDeque<String>(3);

    // 如果可以立即执行此操作，而不会违反容量限制，则在此双端队列的前面插入指定的元素；
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addFirst("c");
    // 这里的插入由于容器没有可用空间，则抛出IllegalStateException
    // deque.addLast("d");

    // 这里的插入成功会返回true,失败会返回false,不会抛出异常
    boolean result = deque.offerFirst("e");
    System.out.println(deque);

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while(deque.size() > 0) {
      // 这里如果LinkedList为空，会返回null
      System.out.println(deque.pollFirst());
    }
    // pop方法,由于容器中没有元素，会抛出异常NoSuchElementException
    // deque.pop();
    /*
    TODO: deque.pollFirst(long timeout, TimeUnit unit) 这个方法是怎么用的?
    */
    System.out.println(deque);
  }
}
```

## 作业二: 分析Queue和Priority Queue的源码

### 分析Queue源码

**1.概述**

> Queue是java中一个接口，默认有LinkedList,LinkedBlockingDeque,PriorityQueue等等多个实现类,这个接口中定义了6个需要实现类实现的方法，如下表:
>
> | 方法定义 | Description |
> | ------------ | --------- |
> | boolean add (E e) | 如果可以立即将指定的元素插入此队列，而不会违反容量限制，则在成功时返回true，如果当前没有可用空间，则抛出IllegalStateException |
> | E element () | 检索但不删除此队列的头,队列为空时，抛出NoSuchElementException |
> | boolean offer (E e) | 如果可以立即将指定的元素插入此队列，而不会违反容量限制，则在成功时返回true,否则返回false |
> | E peek () | 检索但不删除此队列的头部，如果此队列为空，则返回null |
> | E poll () | 检索并删除此队列的头部，如果此队列为空，则返回null |
> | E remove () | 检索并删除此队列的头,队列为空时，抛出NoSuchElementException |

**2.继承关系**

> 在jdk1.8中Queue继承了Collection接口，Collection接口又继承了Iterable,所以Queue也拥有了常规集合的一些行为，尤其是jdk1.8的新特性,Stream流的一系列操作

### 分析Priority Queue的源码

**1.概述**

> PriorityQueue是一个
> * 基于优先级堆的无界优先级队列。
> * 优先级队列的元素按照其自然顺序进行排序，
> * 或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。
> * 优先级队列不允许使用 null 元素。依靠自然顺序的优先级队列还不允许插入不可比较的对象（这样做可能导致 ClassCastException）
>

**2.看源码,自己翻译的,可能会有出入**

> 属性及常量
>
> ```java
> // 默认的容量大小为11
> private static final int DEFAULT_INITIAL_CAPACITY = 11;
> // 队列中元素的个数
> private int size = 0;
> // 比较器，用来给队列中的元素排序，默认为元素们的自然顺序
> private final Comparator<? super E> comparator;
> // FIXME: 这个属性暂时没搞懂是干啥的
> transient int modCount = 0;
> // 这个就是用来存元素的喽
> transient Object[] queue;
> // 队列的最大size,这里减8的官方解释是：虚拟机需要存储数组的头信息
> private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
> ```

> 方法
>
> ```java
> // add方法默认调用了offer方法
> public boolean add(E e) {
>     return offer(e);
> }
>
> public boolean offer(E e) {
>     // 判空
>     if (e == null)
>         throw new NullPointerException();
>     // FIXME:这是要干啥?
>     modCount++;
>     int i = size;
>     // 这里看队列中的元素个数是否大于等于队列现在的长度，是的话，就扩容了
>     if (i >= queue.length)
>         grow(i + 1);
>     size = i + 1;
>     // 如果是插入第一个值，则最简单
>     if (i == 0)
>         queue[0] = e;
>     else
>         // 插入值的逻辑
>         siftUp(i, e);
>     return true;
> }
>
> /**
> * 检索并删除此队列的头部，如果此队列为空，则返回null,时间复杂度受siftDown影响为O(logn)
> */
> @SuppressWarnings("unchecked")
> public E poll() {
>     if (size == 0)
>         return null;
>     int s = --size;
>     modCount++;
>     E result = (E) queue[0];
>     E x = (E) queue[s];
>     queue[s] = null;
>     if (s != 0)
>         // 这里执行重排序
>         siftDown(0, x);
>     return result;
> }
>
> /**
> * 从队列中删除某个元素，时间复杂度是O(n + logn)?
> */
> public boolean remove(Object o) {
>     int i = indexOf(o);
>     if (i == -1)
>         return false;
>     else {
>         removeAt(i);
>         return true;
>     }
> }
>
> @SuppressWarnings("unchecked")
> /**
> * 这里就直接把队列最顶上的元素取出来给你看看就好了
> */
> public E peek() {
>      return (size == 0) ? null : (E) queue[0];
> }
>
> /**
> * 用来查找某个元素所在索引的方法，时间复杂度O(n)
> */
> private int indexOf(Object o) {
>      if (o != null) {
>          for (int i = 0; i < size; i++)
>               if (o.equals(queue[i]))
>                   return i;
>       }
>       return -1;
> }
>
> /**
> * 扩容逻辑，从源码看，在队列的长度小于64时，每次扩容只是加2,否则是乘2扩容
> */
> private void grow(int minCapacity) {
>     int oldCapacity = queue.length;
>     // Double size if small; else grow by 50%
>     int newCapacity = oldCapacity + ((oldCapacity < 64) ?
>                                        (oldCapacity + 2) :
>                                        (oldCapacity >> 1));
>     // overflow-conscious code
>     if (newCapacity - MAX_ARRAY_SIZE > 0)
>         newCapacity = hugeCapacity(minCapacity);
>     queue = Arrays.copyOf(queue, newCapacity);
> }
>
> private void siftUp(int k, E x) {
>      // 如果没有设置比较器，则按元素自然顺序排序
>      if (comparator != null)
>          siftUpUsingComparator(k, x);
>      else
>          siftUpComparable(k, x);
> }
>
> /**
> * 未指定比较器的插入算法
> */
> @SuppressWarnings("unchecked")
> private void siftUpUsingComparator(int k, E x) {
>     while (k > 0) {
>         // 无符号右移
>         int parent = (k - 1) >>> 1;
>         Object e = queue[parent];
>         if (comparator.compare(x, (E) e) >= 0)
>             break;
>         queue[k] = e;
>         k = parent;
>     }
>     queue[k] = x;
> }
> ```
