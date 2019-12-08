# NOTE
### 第一题、将以下事例改为新API重新实现
#### 原题
```java
import java.util.LinkedList;

public class DequeTest {
    public static void main(String[] args) {
        LinkedList<String> deque = new LinkedList<>();
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
    }
}

```
```
运行结果：
[c, b, a]
c
[c, b, a]
c
b
a
[]
```
#### 新版API实现
```java
import java.util.LinkedList;

public class Leetcode_88_MergeSortedArray {
    public static void main(String[] args) {
        LinkedList<String> newDeque = new LinkedList<>();
        newDeque.addFirst("a");
        newDeque.addFirst("b");
        newDeque.addFirst("c");
        System.out.println(newDeque);
        String newStr = newDeque.peekFirst();
        System.out.println(newStr);
        System.out.println(newDeque);
        while (newDeque.size() > 0) {
            System.out.println(newDeque.removeFirst());
        }
        System.out.println(newDeque);
    }
}
```
```
运行结果：
[c, b, a]
c
[c, b, a]
c
b
a
[]
```
### 第二题、分析源码
#### Queue 源码分析
1、继承父类   
```
Queue是一个接口，由子类来具体实现。
Collection --> Iterable --> Object
```
2、方法
```
        引发异常      返回特殊值
插入      add(e)      offer(e)
去掉      remove()    poll()
检查      element()   peek()
```
#### PriorityQueue 源码分析
1、继承父类   
```
AbstractQueue （impl Serializable）--> AbstractCollection (impl Queue) --> Collection --> Iterable --> Object
```
2、分析
```
1. 底层实现是数组：
    transient Object[] queue; // non-private to simplify nested class access
1. 默认长度为11
   private static final int DEFAULT_INITIAL_CAPACITY = 11;
   public PriorityQueue() { this(DEFAULT_INITIAL_CAPACITY, null); }
3. 扩容策略：size < 64 ? size + (size + 2) : size + (size * 1/2)
   最大size：MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
   如果扩容size > MAX_ARRAY_SIZE, return oldSize + 1 , 如果没有超出MAX_ARRAY_SIZE的话
2. 默认排序按字典表顺序进行排序
3. 可以自定义排序方式, 构造方法传入继承Comparator的实现类即可
   PriorityQueue(int initialCapacity, Comparator<? super E> comparator) 
4. PriorityQueue(Collection<? extends E> c) 此构造方法，如果实现子类为SortedSet、PriorityQueue（其本身）, 使用传入实现类的比较器。
   其他Collection 子类则使用默认字典排序, 因为SortedSet、PriorityQueue 自身实现了Comparator
5. 核心思想是使用最小堆结构, 在对queue做poll、remove、add、offer等改变性操作时源码逻辑，主要由两个方法控制：siftUp、siftDown
   siftUp （siftUpComparable、siftUpUsingComparator）: 参数：k、key
     循环 （向上和自己父结点比较小就交换，大就退出）最后将queue[k] = key
   siftDown（siftDownComparable、siftDownComparable）:
     循环 （向下和自己较小的子结点（两个子节点先比较谁小）比较大就交换，小就退出）最后将queue[k] = key
```
### week1分享

```
1. 解题思路
说的简单了一点就是找规律，因为机器能做的就是重复，你给他的指令，能用算法解决的必定有它的规律在其中。
比如递归就要找到出口等

再就是解出来的题目要优化，首先要熟悉时间复杂度、空间复杂度，这就要下功夫去多熟悉甚至背一下

第一周学到哪些：
 1）空间换时间，升维
 2）基础中的数据结构，了解的还是粗浅，需要多看网上大佬的总结博客充实一下，充实思路，加深理解
 3）每天都将前一天的内容过一遍，一周时间将前一周的内容过一遍，加深印象，重在理解思路，动手切不可放下，有思路不一定能写出来！！！


```