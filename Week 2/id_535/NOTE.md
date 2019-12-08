# NOTE

## 1. 写一个关于 HashMap 的小总结。
HashMap不管是在工作还是在面试中出现频率都十分的高频。所以我们有必要了解hashmap的实现机制：
HashMap是键值对的存储结构，HashMap 内部的一些主要特点：
```text
使用哈希表（散列表）来进行数据存储，并使用链地址法来解决冲突
当链表长度大于等于 8 时，将链表转换为红黑树来存储
每次进行二次幂的扩容，即扩容为原容量的两倍
```
我们都知道，Object 类的 hashCode 方法与 HashMap 息息相关，因为 HashMap 便是通过 hashCode 来确定一个 key 在数组中的存储位置。（这里大家都应该了解一下 hashCode 与 equals 方法之间的关系与约定，这里就不多说了）
Java 8 之前的做法和现在的有所不同，Java 8 对此进行了改进，优化了该算法
```java
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}

```
put 方法是 HashMap 里面一个十分核心的方法，关系到了 HashMap 对数据的存储问题。

```java
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}
```

复制代码put 方法直接调用了 putVal 方法：
```java

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    HashMap.Node<K, V>[] tab;
    HashMap.Node<K, V> p;
    int n, i;
    if ((tab = table) == null || (n = tab.length) == 0)
        //初始化哈希表
        n = (tab = resize()).length;
    if ((p = tab[i = (n - 1) & hash]) == null)
        //通过哈希值找到对应的位置，如果该位置还没有元素存在，直接插入
        tab[i] = newNode(hash, key, value, null);
    else {
        HashMap.Node<K, V> e;
        K k;
        //如果该位置的元素的 key 与之相等，则直接到后面重新赋值
        if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        else if (p instanceof HashMap.TreeNode)
            //如果当前节点为树节点，则将元素插入红黑树中
            e = ((HashMap.TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
        else {
            //否则一步步遍历链表
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    //插入元素到链尾
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1)
                        //元素个数大于等于 8，改造为红黑树
                        treeifyBin(tab, hash);
                    break;
                }
                //如果该位置的元素的 key 与之相等，则重新赋值
                if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        //前面当哈希表中存在当前key时对e进行了赋值，这里统一对该key重新赋值更新
        if (e != null) { 
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    //检查是否超出 threshold 限制，是则进行扩容
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}
```


##2 .树的面试题解法一般都是递归，为什么？
递归的本质就是解决重复性相似的问题，树的结构就是若干个类似的重复性的结构。所以一般解法都是采用递归解决

  

