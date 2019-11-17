# HashMap源码学习笔记

> jdk-version: <font color="red">1.8</font>

## 属性

```java
// 默认的初始容量，必须是2的幂
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // 16
// 最大容量
static final int MAXIMUM_CAPACITY = 1 << 30 // 2^30
// 默认的装载因子
static final float DEFAULT_LOAD_FACTOR = 0.75f;
// 使用树而不是链表作为bins的阀值
static final int TREEIFY_THRESHOLD = 8;
// 在resize（）操作中取消树化的阀值,removal系列的操作也会触发取消树化的检测
static final int UNTREEIFY_THRESHOLD = 6;
// 树化时的最小容量(如果bins中又过多节点，会扩容)
static final int MIN_TREEIFY_CAPACITY = 64;
// 实际用来放数据的地方，在第一次put时，初始化为指定的大小
transient Node<K,V>[] table;
//
transient Set<Map.Entry<K,V>> entrySet;
// 当前map中包含的键值对的数量
transient int size;
// 用于并发修改异常的检测机制
transient int modCount;
// 这个值由构造函数中指定的 容量，配合tableSizeFor这个方法来决定，如果不指定，这个值一开始默认是0
int threshold;
// hash table的装载因子
final float loadFactor;
```

## Static utilities

> 在`jdk1.8`中key的hash算法较1.7有所改变,给我的感觉就是看着比以前简单了
> ```java
> static final int hash(Object key) {
>      int h;
>      return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
>  }
>
>  /**
>  * 用来算出hashMap的size大小---oldThr
>  */
>  static final int tableSizeFor(int cap) {
>        int n = cap - 1;
>        n |= n >>> 1;
>        n |= n >>> 2;
>        n |= n >>> 4;
>        n |= n >>> 8;
>        n |= n >>> 16;
>        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
>    }
> ```
> 另外，从这个方法中就可以看出，hashMap的key是可以为`null`的

## get方法

> 从这个get方法中也可以看出，hashMap的值也是可以为`null`的,但经验告诉我们，键值对还是别用`null`的好，下面的put方法会用代码告诉我们原因之一
> ```java
> public V get(Object key) {
>         Node<K,V> e;
>         return (e = getNode(hash(key), key)) == null ? null : e.value;
> }
>
> final Node<K,V> getNode(int hash, Object key) {
>         Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
>         if ((tab = table) != null && (n = tab.length) > 0 &&
>             // 这里利用hash，取出对应位置的节点，做进一步的检查
>             (first = tab[(n - 1) & hash]) != null) {
>             // 这里既检查hash值，考虑到hash碰撞，也对比key的值
>             if (first.hash == hash && // always check first node
>                 ((k = first.key) == key || (key != null && key.equals(k))))
>                 return first;
>             // 如果通过上面两步，还没取到值，说明这是个链表或者树
>             if ((e = first.next) != null) {
>                 // 如果是树，就通过树的方式去查找
>                 if (first instanceof TreeNode)
>                     return ((TreeNode<K,V>)first).getTreeNode(hash, key);
>                 // 否则按链表的方式去查找
>                 do {
>                     if (e.hash == hash &&
>                         ((k = e.key) == key || (key != null && key.equals(k))))
>                         return e;
>                 } while ((e = e.next) != null);
>             }
>         }
>         return null;
>     }
> ```

## put方法

```java
public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
}

/**
* @param onlyIfAbsent 如果是true，就不改变对应key位置上已经存在的值
* @param evict 如果是false，the table is in creation mode(这里其实不太明白).
*/
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        // 如果table为null，说明，这次put操作是第一次发生，这里resize，
        // 相当于做了这么个操作 new Node[DEFAULT_INITIAL_CAPACITY];
        // 如果new HashMap时指定了容量，则相当于new Node[this.threshold]
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        // 接下来通过hash找到对应位置上，如果是null，那直接O(1)完事儿
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        // 否则就是对应位置上有人占了
        else {
            Node<K,V> e; K k;
            // 接下来看看key一样不？一样的话，就把该节点的引用让e先拿着
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            // 否则，是个树节点吗?
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            // 如果不是树，那就是链表了
            else {
                for (int binCount = 0; ; ++binCount) {
                    // 如果p.next为null，就可以直接把val放到链表里了
                    if ((e = p.next) == null) {
                        // 这里看操作是直接放到链表尾部了
                        p.next = newNode(hash, key, value, null);
                        // 这里把val放入链表后，判断是否超过树化的阀值
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // 这里这步操作是为了配合putIfAbsent的操作，由参数onlyIfAbsent决定
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                // 这里可以看出，如果你对应节点的原值为null，是无论如何都会被后来的值覆盖的
                // 所以一般不推荐val为null
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                // FIXME: 把节点移到末尾,为啥要这么做呀?
                afterNodeAccess(e);
                // 返回该节点之前的值
                return oldValue;
            }
        }
        ++modCount;
        // 这里检查是否需要扩容
        if (++size > threshold)
            resize();
        // FIXME: 这是个神马操作?
        afterNodeInsertion(evict);
        return null;
    }
```

# 可能晚点儿再来更新
