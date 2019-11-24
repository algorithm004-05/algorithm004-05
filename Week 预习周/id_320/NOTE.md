# NOTE

## Week 预习周
数据结构和算法大部分地内容都学过，但是在画脑图的过程中，才更深刻体验到自己的学习是那么地零散，画起脑图来一脸地懵逼，需要各种找资料拼凑总结，后续地学习需要**考虑如何将学习内容系统化**。

目前画地数据结构和算法脑图仅打开，再后续地学习过程中再持续完善。



## Week 01
### 知识点总结
#### 数组
##### 复杂度总结
|            | 随机访问    | 插入                   | 更新        | 删除                   |
| ---------- | ----------- | ---------------------- | ----------- | ---------------------- |
| 操作       | 定位 + 读取 | 定位 + 向后群移 + 写入 | 定位 + 写入 | 定位 + 移除 + 向前群移 |
| 时间复杂度 | O(1)        | O(n)                   | O(1)        | O(n)                   |

#### 链表
##### 复杂度总结
|            | 随机访问    | 插入(头部/中间/尾部) | 更新        | 删除            |
| ---------- | ----------- | -------------------- | ----------- | --------------- |
| 操作       | 定位 + 读取 | 定位 + 调整指针      | 定位 + 写入 | 定位 + 调整指针 |
| 时间复杂度 | O(n)        | **O(n)**                 | **O(n)**        | **O(n)**           |

**疑惑：为什么要忽略链表定位的时间复杂度，从而把链表的插入和删除时间复杂度定为O(1)**

##### 在JAVA 8中的定义

```java
// 双向指针 Node节点不序列化
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable {
    
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;
    
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
	}
}

```

#### 跳表

跳表是对链表随机访问性能进行空间换时间优化的产物。跳表的随机访问性能降为log2(n)- 1，但是维护成本随着索引的层级的增加而大大增加。

![1571576396677](./images/1571576396677.png)



#### 栈

Stack：先入后出；添加、删除皆为 O(1) 

##### 在JAVA 8中的定义

```java
public class Stack<E> extends Vector<E> {
    // 注意peek()与pop()的区别，peek()元素不弹出
}
```

在Java中Stack不常用，一般使用Deque代替。

#### 队列

Queue：先入先出；普通队列添加、删除皆为 O(1) 

```java
public interface Queue<E> extends Collection<E> {
    // offer() && pop()在队列空或满时不抛异常
    // add() && remove()在队列空或满时抛异常
}
```

##### java中的优先队列分析

在Java中的优先队列是通过**二叉堆**实现的，而且是最小堆，底层使用数组进行存储。它的插入和取出操作的复杂度应为**O(logN) ** 【**这跟课件的说法并不一致**】。核心处理方法为siftUp()和siftDown()

```java
public class PriorityQueue<E> extends AbstractQueue<E> implements java.io.Serializable {

	// 二叉堆底层通过数组进行存储
	transient Object[] queue;
	
    public boolean add(E e) {
        return offer(e);
    }
    public boolean offer(E e) {
        //略
            siftUp(i, e);
        return true;
    }
    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }

	// 二叉堆新元素小于父级节点则上浮
    @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            // 二叉堆新元素大于等于父级节点则break
            if (key.compareTo((E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    }
    
    // 二叉堆新元素大于右节点则下沉
    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // assume left child is least
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];
            // 二叉堆新元素小于右节点则break
            if (key.compareTo((E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = key;
    }
}
```
## Week 02 HashMap 小总结（Java8）


hash函数

HashMap的性能取决于hash函数，理论上时间复杂度为O(1)， java8中的hash函数为：

```java
 static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
 }
```

计算指定key的hash值，原理是将key的hash code与hash code无符号向右移16位的值，执行异或运算。在Java中整型为4个字节32位，无符号向右移16位，表示将高16位移到低16位上，然后再执行异或运行，也就是将hash code的高16位与低16位进行异或运行。

* 小于等于65535的数，其高16位全部都为0，因而将小于等于65535的值向右无符号移16位，则该数就变成了32位都是0，由于任何数与0进行异或都等于本身，因而hash code小于等于65535的key，其得到的hash值就等于其本身的hash code。

**不太理解设计这样的hash函数有什么好处？**

#### HashMap的存储结构
HashMap是通过数组存储所有的数据，每个元素所存放数组的下标，是根据该存储元素的key的Hash值与该数组的长度减去1做与运算得到的。
数组中存放元素的数据结构使用了Node和TreeNode两种数据结构。
* 在单个Hash值对应的存储元素小于8个时，默认值为Node的单向链表形式存储；
* 当单个Hash值存储的元素大于8个时，其会使用TreeNode的数据结构存储；

#### HashMap的putVal()源码分析

```java
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
         // 如果table数组为null,则通过扩容方法创建一个默认容量为16的Node节点数组
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
         // 根据(n - 1) & hash来决定元素的储存index
         // 如果对应index的元素为null，则直接创建新节点赋值给tab[i]即可
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            // 如果待存key与现有key(即tab[i])的hash相等且key数值相等
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //判断取的对象是不是TreeNode，如果是则执行TreeNode的put方法
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                // 普通Node节点，根据next属性对元素p执行单向链表的遍历
                for (int binCount = 0; ; ++binCount) {
                    // 末端节点附加新节点
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        // 判断当前节点的单向链接的数量（8个）是不是已经达到了需要将其转换为TreeNode
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // 判断待插入的元素的hash值与key是否与单向链表中的某个元素的hash值与key是相同的，如果是则退出
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            // 判断是否找到了与待插入元素的hash值与key值都相同的元素
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                //判断是否要将旧值替换为新值
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```

## Week 03 学习总结

####  课后作业题

使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方

思路： 

* 如果是升序，即nums[pivot] > nums[left]，则left = pivot；
* 反之，无序位一定在其中，再次折半比较该前移还是后移;
  * 升序，即nums[pivot] > nums[left]，则后移；
  * 反之，左移;

**这里要注意一下while的条件为left < right，不然无法跳出循环**

```java
private static int search(int[] nums) {
    if (nums == null || nums.length == 0) {
        return -1;
    }
    int left = 0, right = nums.length - 1, pivot;
    while (left < right) {
        pivot = (left + right) / 2;
        if(nums[pivot] > nums[left]) {
            left = pivot;
        } else {
            pivot = (left + right) / 2;
            if(nums[pivot] > nums[left]) {
                left = pivot;
            } else {
                right = pivot;
            }
        }
    }
    return left + 1;
}
```



#### 深度优先搜索模板（DFS） 

![1572750838100](.\images\1572750838100.png)

![1572750994670](.\images\1572750994670.png)



#### 广度优先搜索模板（BFS） 

![1572751110190](.\images\1572751110190.png)



#### 贪心算法 

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

##### 与动态规划的区别

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不
能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行
选择，有回退功能。 

##### 适用贪心算法的场景

简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终
问题的最优解。这种子问题最优解称为最优子结构。 



#### 二分查找 

##### 二分查找的前提条件

* 目标函数单调性

* 存在上下界

* 能够通过索引访问

##### 代码模板

![1572751436218](.\images\1572751436218.png)



## Week 05 学习总结

#### 动态规划

动态规划是一种通过把原问题分解为相对简单的子问题的方式求解复杂问题的方法，常常适用于有重叠子问题和最优子结构性质的问题，其所耗时间往往远少于朴素解法。

其基本思想也是将待求解问题分解成若干个子问题，先求解子问题，然后从这些子问题的解得到原问题的解。与分治法不同的是，适合于用动态规划求解的问题，经分解得到子问题往往不是互相独立的。若用分治法来解这类问题，则分解得到的子问题数目太多，有些子问题被重复计算了很多次。如果我们能够保存已解决的子问题的答案，而在需要时再找出已求得的答案，这样就可以避免大量的重复计算，节省时间。我们可以用一个表来记录所有已解的子问题的答案。不管该子问题以后是否被用到，只要它被计算过，就将其结果填入表中。这就是动态规划法的基本思路。

参考文献：[动态规划]([https://baike.baidu.com/item/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/529408?fr=aladdin](https://baike.baidu.com/item/动态规划/529408?fr=aladdin))



#### 动态规划关键点

1. 最优子结构 opt[n] = best_of(opt[n-1], opt[n-2], …)
2. 储存中间状态：opt[i]  
3. 递推公式（美其名曰：状态转移方程或者 DP 方程）
Fib: opt[i] = opt[n-1] + opt[n-2]
二维路径：opt[i,j] = opt[i+1][j] + opt[i][j+1] (且判断a[i,j]是否空地 )



#### 归纳与分治的区别

共同点： 同样为将待求解问题分解成若干个子问题，求解重复子问题；

差异性：

- 动态规划在求解过程中会寻找最优子结构，淘汰次优结构；
- 动态规划通常自底向上开始计算（与递归不同），保存计算过子问题的答案，不再重复计算；

