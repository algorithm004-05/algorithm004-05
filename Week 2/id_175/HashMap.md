# HashMap

## put

![Put](https://github.com/shizeying/algorithm004-05/blob/master/Week%202/id_175/putVal.png)

1. 判断键值对数组<B>table[i]</B>是否为null,否则进行<B>resize()</B>扩容
2. 根据key值计算<B>hash</B>值得到插入的数组索引<B>i</B>如果<B>table[i]=null</B>,直接新建结点添加,转向<B><u>(6)</u></B>,如果<B>table[i]</B>不为空,转向<B><u>(3)</u></B>;
3. 判断<B>table[i]</B>的首个元素是否和<B>key</B>一样,如果相同直接覆盖<B>value</B>否则转向<B><u>(4)</u></B>,这里相同指的是<B>hashCode</B>和<B>equals</B>;
4. 判断<B>table[i]</B>是否为<B>treeNode</B>,即<B>table[i]</B>是否为红黑树,如果是,则直接在树中插入键值对,否则转向<B><u>(5)</u></B>;
5. 遍历<B>table[i]</B>,判断链表长度是否<B>大于8</B>,<B>大于8</B>的话就吧链表转换为红黑树,在红黑树中执行插入操作,否则进行链表的插入操作;在遍历过程中若发现<B>key</B>已经存在直接覆盖<B>value</B>即可
6. 插入成功后,判断实际存在的键值对数量<B>size</B>是否超过了*最大容量*的<B>threshold</B>,如果超过进行<B>扩容</B>

```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    //创建table的索引
    Node<K, V>[] tab;
    //p是散列到位置的元素
    Node<K, V> p;
    //n是table的长度,i是散列到的位置,公式:i=(n-1)&length
    int n, i;
    //如果表为null或者长度为0,n和tab在此刻赋值
    if ((tab = table) == null || (n = tab.length) == 0) {
        //填充table长度
        n = (tab = resize()).length;
    }
    //如果我们的散列到的位置是null,说明这个桶还没有存在过结点所以创建新的结点放入桶中,请注意:p,i在这里已经是赋值过的状态咯
    if ((p = tab[i = (n - 1) & hash]) == null) {
        //创建新的结点
        tab[i] = newNode(hash, key, value, null);
        //其他的情况就是散列到的桶里面的东西
    } else {
        //Node结点e,用来遍历链表或者数
        Node<K, V> e;
        //获取p的值
        K k;
        //如果桶里的p元素和hash值传入的hash值相等
        if (p.hash == hash &&
            //并且其不为null,键值也相等,此时K赋值
            ((k = p.key) == key || (key != null && key.equals(k)))) {
            //此时说明它们是同一个元素,是开头结点,就通过红黑树方式放入
            e = p;
            //如果是红黑树结点,就通过红黑树的方式放入
        } else if (p instanceof TreeNode)
            e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
        //这种情况就是hash不一样的时候了,并且是链表的情况,请注意:键值一样hash值是一定相同搞得;键值不一样时,就会出现两种情况,可能相同,也可能不相同
        else {
            //循环链表
            for (int binCount = 0; ; ++binCount) {
                //如果e的下个结点是null,说明新加入的元素要放到e的后面连接起来
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    //树化,只有子啊成功创建结点之后才会考虑到是否树化,当链表的长度阈值达到-1的时候,就把链表转化为红黑树::::::JDK8的特点
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    //插入后退出
                    break;
                }
                //如果存在的元素值和插入的元素值相同,那就挺直插入,直接退出啊这个元素的添加流程
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                //下标移动
                p = e;
            }
        }
        //如果不为空,也就是e已经添加到表中了
        if (e != null) { // existing mapping for key
            // 记录下e的value的值
            V oldValue = e.value;
            //因为onlyIfAbsent是false才会进来,或改变已存在的元素,所以e被赋值上了新值,如果旧的值为null,就返回null
            if (!onlyIfAbsent || oldValue == null) {
                //这种情况应该是存在插入的元素相同的情况,然后新的值覆盖旧的值
                e.value = value;
            }
            //表示赋值之后
            afterNodeAccess(e);
            //返回旧值
            return oldValue;
        }
    }
    //修改次数++
    ++modCount;
    //++size是添加了一个元素厚的大小,如果比阈值大就要扩容
    if (++size > threshold) {
        //扩容平
        resize();
    }
    //插入结束
    afterNodeInsertion(evict);
    return null;
}
```

## get

在最差的情况下,链表过长的时候,时间复杂度就变成了<font size=6><B>O(n)​</B></font>了,哈希表就变成像废纸一样,所以1.8中就将链表转化为了红黑树,把查询时间将为了<img src="https://github.com/shizeying/algorithm004-05/blob/master/Week%202/id_175/CodeCogsEqn.svg"></img>，尤其是数据量巨大的时候，这种算法就很有效了


```java
public V get(Object key) {
    Node<K, V> e;
    /**
		 * 调用getNode(hash,key)函数,判断结点是否存在,存在:返回e.value;否则返回null
		 */
    return (e = getNode(hash(key), key)) == null ? null : e.value;
}
final Node<K, V> getNode(int hash, Object key) {
    //创建一个table的副本,使用副本进行操作
    Node<K, V>[] tab;
    //first表示这个桶中的第一个元素,e是作为一个游标,遍历这个链表
    Node<K, V> first, e;
    //n是table 的长度
    int n;
    //k表示每一个结点的键值key
    K k;
    /**
		 * 1.table!=null,也就是说数组内是有记录的,否则直接null,查询不到记录
		 * 2.n>0,是为了n-1依然在table范围内
		 * 3.根据哈希表元素个数与哈希值求模,公式:(n-1)&hash,得到key所在的桶的头结点,因为散列的第一个就是头结点
		 * (如果头结点恰好是红黑树节点,就调用红黑树节点的getTreeNode方法,否则遍历链表节点)
		 */
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (first = tab[(n - 1) & hash]) != null) {
        //如果头结点就直接是我们要找的数据就直接返回
        if (first.hash == hash && // always check first node
            ((k = first.key) == key || (key != null && key.equals(k))))
            return first;
        //当头结点还有后续的时候,就进入这个循环
        if ((e = first.next) != null) {
            //如果是红黑树,就用树的查询方式
            if (first instanceof TreeNode)
                return ((TreeNode<K, V>) first).getTreeNode(hash, key);
            do {
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
                //否则就是链表的节点就挨个遍历
            } while ((e = e.next) != null);
        }
    }
    return null;
}
```

1. [美团技术团队](https://tech.meituan.com/2016/06/24/java-hashmap.html)
2. [高能Java总结](https://zhuanlan.zhihu.com/c_183175878)