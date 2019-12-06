# NOTE



#### 变量
```
//默认hash桶初始长度16
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; 

//hash表最大容量2的30次幂
static final int MAXIMUM_CAPACITY = 1 << 30;

//默认负载因子 0.75
static final float DEFAULT_LOAD_FACTOR = 0.75f;

//链表的数量大于等于8个并且桶的数量大于等于64时链表树化 
static final int TREEIFY_THRESHOLD = 8;

//hash表某个节点链表的数量小于等于6时树拆分
static final int UNTREEIFY_THRESHOLD = 6;

//树化时最小桶的数量
static final int MIN_TREEIFY_CAPACITY = 64;
```

```
//hash桶
transient Node<K,V>[] table;                         

//键值对的数量
transient int size;

//扩容的阀值，当键值对的数量超过这个阀值会产生扩容
int threshold;

//负载因子
final float loadFactor;
```
#### jdk 1.8 hashMap putVal
    1、总结来说就是数组表为空，初始化
    2、如果put的对象，hash值在表中位置没有值，则直接put
    3、如果有值，遍历该hash值处的链表，如果key相等，覆盖掉
    4、如果不想等，结点为treeNode结构，在红黑树添加结点
    5、否则，在链表最后插入这个结点
```
public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        // table为空或length为0
        if ((tab = table) == null || (n = tab.length) == 0) 
            // 初始化
            n = (tab = resize()).length;
        // 如果hash所在位置为null，直接put
        if ((p = tab[i = (n - 1) & hash]) == null) 
            tab[i] = newNode(hash, key, value, null);
        else { 
        // tab[i]有元素，遍历节点后添加
            Node<K,V> e; K k;
            // 如果hash、key都相等，直接覆盖
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode) // 红黑树添加节点
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else { // 链表
                for (int binCount = 0; ; ++binCount) {
                    // 找到链表最后一个节点，插入新节点
                    if ((e = p.next) == null) { 
                        p.next = newNode(hash, key, value, null);
                        // 链表节点大于阈值8，调用treeifyBin方法，当tab.length大于64将链表改为红黑树
                        // 如果tab.length < 64或tab为null，则调用resize方法重构链表.
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // hash、key都相等，此时节点即要更新节点
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            // 当前节点e = p.next不为null，表示链表中原本存在相同的key，则返回oldValue
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                // onlyIfAbsent值为false，参数主要决定存在相同key时是否执行替换
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold) // 检查是否超过阈值
            resize();
        afterNodeInsertion(evict);
        return null; // 原HashMap中不存在相同的key，插入键值对后返回null
    }
```


1、二叉树、二叉查找树

	二叉查找树：
		1）左子树上的结点都小于根结点，右子树的结点都大于根结点；
		2）且不存在相同的结点；
		3）子树也遵循第一条；

2、泛型递归、树递归

	递归：将问题可拆分为子问题，子问题，拆分为相同子问题，最终拆分为可解决的子问题的思想
	递归要有临界出口，即最终子问题是可解决的；
	找到重复性；
```	
套用模版：

public void recur(int level, int param) { 
  // terminator 出口
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 
  // process current logic  当前的逻辑过程
  process(level, param); 
  // drill down  下钻
  recur( level: level + 1, newParam); 
  // restore current status 恢复状态
}
```
分治、回溯

	分治策略是：对于一个规模为n的问题，若该问题可以容易地解决（比如说规模n较小）则直接解决，否则将其分解为k个规模较小的子问题，这些子问题互相独立且与原问题形式相同，递归地解这些子问题，然后将各子问题的解合并得到原问题的解。这种算法设计策略叫做分治法。
	分治法在每一层递归上都有三个步骤：
	    step1 分解：将原问题分解为若干个规模较小，相互独立，与原问题形式相同的子问题；
	    step2 解决：若子问题规模较小而容易被解决则直接解，否则递归地解各个子问题
	    step3 合并：将各个子问题的解合并为原问题的解。
    总结来说就是相似于数学归纳法，找到公式通过代码实现程序。

	回溯：在包含问题的所有解的解空间树中，按照深度优先搜索的策略，从根结点出发深度探索解空间树。当探索到某一结点时，要先判断该结点是否包含问题的解，如果包含，就从该结点出发继续探索下去，如果该结点不包含问题的解，则逐层向其祖先结点回溯。（其实回溯法就是对隐式图的深度优先搜索算法）。
	回溯法步骤：
	针对所给问题，确定问题的解空间：
		step1 首先应明确定义问题的解空间，问题的解空间应至少包含问题的一个（最优）解。
		step2 确定结点的扩展搜索规则。
		step3 以深度优先方式搜索解空间，并在搜索过程中用剪枝函数避免无效搜索。
	
```
套用模版：
int a[n];
try(int i) {
    if(i>n) {
     输出结果;
     } else {
      // 枚举i所有可能的路径
       for(j = 下界; j <= 上界; j=j+1) {
       // 满足限界函数和约束条件
           if(fun(j)) {
                a[i] = j;
              ...                         // 其他操作
                try(i+1);
              回溯前的清理工作（如a[i]置空值等）;
              }
         }
     }
}
```