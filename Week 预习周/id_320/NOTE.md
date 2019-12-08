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

## Week 06 学习总结

#### 字典树 Trie

字典树是一种多叉树，其特点是每个节点有代表其到下一级对应节点的边来表示的字符。字典树主要用于对单词或短语的查找和统计，在该用例下，将一个单词按字母进行拆分，或者将一个短语按照单词进行拆分，拆分出来的每一段均对应树的某一个层。从根节点开始，根节点表示第一个字符或者第一段，从该节点向下根据可能的第二个字符或第二段的出现的所有选项来分别建立一条边，该边则代表了第一 + 第二个字符或者分段出现的情况，节点本身并不保存单词本身。该方法在查询时由于提前进行前缀匹配，减少了额外的字符串比较，本质上是通过空间来换时间。

##### 字典树的基本性质

1. 节点本身不保存完整的单词
2. 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
3. 每个节点的所有子节点路径代表的字符都不相同

#### 并查集

并查集是一种主要用于查找两个元素对应的集合的关系的数据结构，其核心思想是通过指定一个集合的代表，并且建立起集合内所有节点通过父节点最终指向该代表的方式，来在不遍历的情况下确认两个元素是否属于同一个集合，或者是当前有几个不相交的集合。所有连通的集合内部是一个反向的树状结构，有一个根节点，以及父子节点的关系，但是是子节点指向父节点的方向。根节点的父节点是其本身。

并查集主要有下面三个操作

1. `makeSet(s)` 建立一个并查集，其中所有节点都是根节点
2. `unionSet(x, y)` 如果 x 和 y 所在的集合不相交，则将两个集合的代表其中一个作为另一个的代表，使得两个集合相交
3. `find(x)` 找到元素 x 所在的集合的代表
#### 高级搜索

##### 回溯法
回溯法是在搜索的基础上，在尝试发现现有的搜索路径上不能得到答案的情况下，回溯到上层，从另一个还未尝试的状态分支继续进行搜索的一种思路。回溯法一般跟搜索一样也采用递归的方式进行。

##### 双向 BFS

双向 BFS 是在 BFS 上的一种升级，单纯的 BFS 根据其分支数量的不同，有可能会扩散得很大，在达到预期的层数之前会在两侧进行许多的无效计算。双向 BFS 的想法则是在此基础之上，从出发点和目标点同时相对进行 BFS，这样的话每一侧的 BFS 都只需要走一半的层数，就会互相发现对方已经探索过的点，那扩散的范围就会显著减小，也就是会显著减少无效的计算量。

##### 启发式搜索 A*

启发式搜索也是对 BFS 的一种升级。这个方式的本质就是在 BFS 的基础上，优化了对下一个搜索目标的选择，故增加了优先找到目标的概率。原始的 BFS 使用一个 FIFO 来保存接下来需要探索的节点，所以对优先探索的节点的选择仅跟时间有关。启发式搜索在此基础上将 FIFO 替换成了优先队列，通过一个估价函数来计算接下来首先寻找哪个节点可以更接近目标。这个估价函数根据具体情况而定，其余的部分跟 BFS 一致。

#### AVL 树

AVL 树是一种可以解决树的平衡性问题的数据结构，其在二叉搜索树的基础上通过增加了平衡因子来判断当前树以及其中的每个节点是否平衡，以及在不平衡时采取的一系列措施，来保持树的平衡性。树的平衡性会直接影响树的层高，也就会直接影响搜索的效率。

AVL 树在只要出现不平衡的节点时就会进行平衡操作。平衡操作有四种

1. 左旋
2. 右旋
3. 左右旋
4. 右左旋

在进行平衡操作以后，树会回到平衡状态。但是在不理想的情况下该操作会被频繁触发，并且每个节点需要保存平衡因子，所以 AVL 树的维护成本很高

#### 红黑树

红黑树也是一种尝试解决树的平衡性问题的数据结构。跟 AVL 树不同的是，红黑树通过牺牲平衡性来减少维护成本。红黑树允许最多 2 倍的高差，而不是平衡性要求的 1 的高差，所以是一种近似平衡的二叉树。同时因为允许少量的平衡，故大大减少了触发平衡操作的概率，同时也仅需要少量空间记录节点的颜色。

红黑树有下面五条性质

1. 每个节点要么是红色，要么是黑色
2. 根节点是黑色
3. 每个叶节点(NIL 节点，空节点) 是黑色
4. 不能有相邻接的两个红色节点
5. 从任一节点到其每个叶子节点的所有路径都包含相同数目的黑色节点



## Week 07 学习总结

#### 位运算

##### 异或
- x ^ 0 = x
- x ^ 1s = ~x // 注意 1s = ~0
- x ^ (~x) = 1s
- x ^ x = 0
- c = a ^ b => a ^ c = b, b ^ c = a // 交换两个数
- a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c // associative

##### 指定位置的位运算
- 将 x 最右边的 n 位清零：x & (~0 << n)
- 获取 x 的第 n 位值（0 或者 1）： (x >> n) & 1
- 获取 x 的第 n 位的幂值：x & (1 << (n -1))
- 仅将第 n 位置为 1：x | (1 << n)
- 仅将第 n 位置为 0：x & (~ (1 << n))
- 将 x 最高位至第 n 位（含）清零：x & ((1 << n) - 1)
- 将第 n 位至第 0 位（含）清零：x & (~ ((1 << (n + 1)) - 1))

#####  实战位运算要点
- 判断奇偶：
  x % 2 == 1 —> (x & 1) == 1
  x % 2 == 0 —> (x & 1) == 0
- x >> 1 —> x / 2
  即： x = x / 2; —> x = x >> 1;
  mid = (left + right) / 2; —> mid = (left + right) >> 1;
- X = X & (X-1) 清零最低位的 1
- X & -X => 得到最低位的 1
- X & ~X => 0

####  LRU Cache（Java实现）


```java
	public class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

```

#### 归并排序 （ Java 实现）

```java
public void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2
    
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public void merge(int[] arr, int left, int mid, int right) {
	int[] temp = new int[right - left + 1]; // 中间数组
	int i = left, j = mid + 1, k = 0;

	while (i <= mid && j <= right) {
		temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
	}
	
	while (i <= mid) temp[k++] = arr[i++];
	while (j <= right) temp[k++] = arr[j++];

	for (int p = 0; p < temp.length; p++) {
		arr[left + p] = temp[p];
	}
	// 也可以⽤ System.arraycopy(a, start1, b, start2, length)
}
```

