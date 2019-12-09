# NOTE
### 一：用 add first 或 add last 这套新的 API 改写 Deque 的代码
原例：
```java
        Deque<String> deque = new LinkedList<String>(); 
        deque.push("a"); 
        deque.push("b"); 
        deque.push("c"); 
        System.out.println(deque); 
        String str = deque.peek(); 
        System.out.println(str); 
        System.out.println(deque); 
        while (deque.size() > 0) {   
            System.out.println(deque.pop()); 
        } 
        System.out.println(deque); 
```
用addFirst修改：
```java
        Deque<String> deque = new LinkedList<String>(); 
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str1 = deque.peek();
        System.out.println(str1);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
```


  


### 二：Priority Queue学习总结
它是一种基于优先级堆的极大优先级队列。优先级队列是不同于先进先出队列的另一种队列。每次从队列中取出的是具有最高优先权的元素。如果不提供Comparator的话，优先队列中元素默认按自然顺序排列，也就是数字默认是小的在队列头，字符串则按字典序排列（参阅 Comparable），也可以根据 Comparator 来指定，这取决于使用哪种构造方法。优先级队列不允许 null 元素。依靠自然排序的优先级队列还不允许插入不可比较的对象
```java
public class PriorityQueueExample {

	public static void main(String[] args) {
		Queue<Integer> qi = new PriorityQueue<Integer>();

		qi.add(5);
		qi.add(2);
		qi.add(1);
		qi.add(10);
		qi.add(3);

		while (!qi.isEmpty()) {
			System.out.print(qi.poll() + ",");
		}
		System.out.println();
		System.out.println("-----------------------------");
              // 自定义的比较器，可以让我们自由定义比较的顺序 Comparator<Integer> cmp;
		cmp = new Comparator<Integer>() { 
			public int compare(Integer e1, Integer e2) {
				return e2 - e1;
			}
		};
		Queue<Integer> q2 = new PriorityQueue<Integer>(5, cmp);
		q2.add(2);
		q2.add(8);
		q2.add(9);
		q2.add(1);
		while (!q2.isEmpty()) {
			System.out.print(q2.poll() + ",");
		}

	}

}
```
输出：
```text
1,2,3,5,10,
-----------------------------
9,8,2,1,
```
#### API
```java
//默认用于存储节点信息的数组的大小
private static final int DEFAULT_INITIAL_CAPACITY = 11;
//用于存储节点信息的数组
transient Object[] queue;
//数组中实际存放元素的个数
private int size = 0;
//Comparator比较器
private final Comparator comparator;
//用于记录修改次数的变量
transient int modCount = 0;
```
#### 方法剖析
添加：boolean add(E e) 和boolean offer(E e)

```java
    public boolean add(E e) {
        return offer(e);
    }

   
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }
```
实际上add方法的内部调用的还是offer方法，所以我们主要看看offer是如何实现添加一个元素到堆结构中并维持这种结构不被破坏的。首先该方法定义了一 变量获取queue中实际存放的元素个数，紧接着一个if判断，如果该数组已经被完全使用了（没有可用空间了），会调用grow方法进行扩容，grow方法会根据具体情况判断，如果原数组较大则会扩大两倍+2，否则增加50%容量，由于具体代码比较清晰，此处不再赘述。
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
接着判断该完全二叉树是否为空，如果没有任何节点，那么直接将新增节点作为根节即可，否则会调用siftUp添加新元素并调整结构，所以该方法是重点。
```java
    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }
```