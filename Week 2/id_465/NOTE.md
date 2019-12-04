# NOTE

## [Java Map](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html) & [Java Set](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html)

### 常用实现Map接口的容器
[HashMap](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/HashMap.html)及[TreeMap](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/TreeMap.html)为常用Map容器；此外还有[LinkedHashMap](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/LinkedHashMap.html)，`LinkedHashMap`是`HashMap`的子类。
- **获取数据的顺序**。遍历`HashMap`时，取得数据的顺序时随机的，与插入数据的顺序无关，也并非已经过排序的。用`Iterator`遍历`LinkedHashMap`时取得数据的顺序与插入顺序一致。用`Iterator`遍历`TreeMap`时，默认时升序排列的。
- `HashMap`迭代性能与实例的容量（bucket的数量）以及其大小（K-V映射关系数）有关。`HashMap`提供带`float loadFactor`的构造函数（默认为0.75），当bucket被填满到loadFactor时，会创建两倍的bucket数组。
- `HashMap`依赖`hashCode`以及`equals`两个函数。其中`hashCode`用于确定bucket位置，bucket中存储了键值对数据，作为`Map.Entry`。在定位到bucket之后，再调用`equals`获取相应的K-V值，K-V值在bucket中已链表存心户。
- `String`类不可变对象非常适合作为键值。如果作为键值的对象是可变的，则应保证`put`时以及后续`get`时`hashCode`获得的值是一致的。

### 常用实现Set接口的容器
[HashSet](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/HashSet.html)及[TreeSet](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/TreeSet.html)为常用Set容器；此外还有[LinkedHashSet](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/LinkedHashSet.html)，`LinkedHashSet`是`HashSet`。三个容器的关系实现都由相应的Map实现。

## 递归模板
```Java
public void recur(int level, int param){
    // terminator
    if(level>MAX_LEVEL){
        // process result
        return;
    }

    // process current logic
    process(level, param)

    // drill down
    recur(level+1, newParam);

    // restore current status
}
```

## 作业
- [x] [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)
- [x] [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)
- [x] [1. 两数之和](https://leetcode-cn.com/problems/two-sum/description/)
- [x] [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
- [x] [589. N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)