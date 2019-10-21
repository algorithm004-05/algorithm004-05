# NOTE

### 改写Deque 作业
```text
        Deque<String> deque = new LinkedList<String>();

        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
         
        System.out.println(deque);

        String str = deque.getLast();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeLast());
        }
        System.out.println(deque);
```


  
### Queue 源码分析
Queue：一个先进先出的数据结构。
Queue继承了Collection接口，与Set和List同一级别。
该结构定义了如下方法：
boolean add(E e); //添加一个元素，如果队列已满抛出IllegalStateException异常
E remove(); //移除头部元素，队列为空抛出NoSuchElementException;
E element();//获取头部元素，不出队，队列为空，抛出异常。

boolean offer(E e); //添加一个元素，如果队列已满返回false。
E poll(); //移除头部元素，队列为空返回null。
E peek();//获取头部元素，不出队，队列为空，返回null

#### Queue 的子类/实现

PriorityQueue 和 ConcurrentLinkedQueue
　　PriorityQueue 和 ConcurrentLinkedQueue 类在 Collection Framework 中加入两个具体集合实现。 
　　PriorityQueue 类实质上维护了一个有序列表。加入到 Queue 中的元素根据它们的天然排序（通过其 java.util.Comparable 实现）或者根据传递给构造函数的 java.util.Comparator 实现来定位。
　　ConcurrentLinkedQueue 是基于链接节点的、线程安全的队列。并发访问不需要同步。因为它在队列的尾部添加元素并从头部删除它们，所以只要不需要知道队列的大 小，　　　　    　　ConcurrentLinkedQueue 对公共集合的共享访问就可以工作得很好。收集关于队列大小的信息会很慢，需要遍历队列。


　　java.util.concurrent 中加入了 BlockingQueue 接口和五个阻塞队列类。它实质上就是一种带有一点扭曲的 FIFO 数据结构。不是立即从队列中添加或者删除元素，线程执行操作阻塞，直到有空间或者元素可用。
五个队列所提供的各有不同：
　　* ArrayBlockingQueue ：一个由数组支持的有界队列。
　　* LinkedBlockingQueue ：一个由链接节点支持的可选有界队列。
　　* PriorityBlockingQueue ：一个由优先级堆支持的无界优先级队列。
　　* DelayQueue ：一个由优先级堆支持的、基于时间的调度队列。
　　* SynchronousQueue ：一个利用 BlockingQueue 接口的简单聚集（rendezvous）机制。

#### PriorityQueue 源码分析
优先队列的作用是能保证每次取出的元素都是队列中权值最小的，PriorityQueue通过二叉小顶堆实现，可以用一棵完全二叉树表示。
元素大小的评判可以通过元素本身的自然顺序（natural ordering），也可以通过构造时传入的比较器（Comparator）。
Java中PriorityQueue实现了Queue接口，不允许放入null元素；其通过堆实现，具体说是通过完全二叉树（complete binary tree）实现的小顶堆（任意一个非叶子节点的权值，都不大于其左右子节点的权值），也就意味着可以通过数组来作为PriorityQueue的底层实现。
add(E e)和offer(E e)的语义相同，都是向优先队列中插入元素，只是Queue接口规定二者对插入失败时的处理不同，前者在插入失败时抛出异常，后则则会返回false。对于PriorityQueue这两个方法其实没什么差别。
element()和peek()的语义完全相同，都是获取但不删除队首元素，也就是队列中权值最小的那个元素，二者唯一的区别是当方法失败时前者抛出异常，后者返回null。
remove()和poll()方法的语义也完全相同，都是获取并删除队首元素，区别是当方法失败时前者抛出异常，后者返回null。
