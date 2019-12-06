# 505-WEEK02

  本周学习的内容比较多，经常用来空间换时间的哈希表，和递归配合非常默契的树，递归的升级版回溯和分治。

### 哈希表

虽然对 `Java` 不熟悉，但是还是查找了很多资料研究了 `HashMap` 这个数据结构的实现。对自己最有感悟的是简书的这篇文章。地址 [在此](https://www.jianshu.com/p/ee0de4c99f87)。`HashMap` 由数组+链表+红黑树组成。通过计算哈希值得到数组下标时间复杂度为O(1)，如果拉链下元素少，用链表存储，如果大于一定值时转换为红黑树存储。这篇文章还主要讲了 `HashMap` 的 `resize`， 当`HashMap` 扩展的时候，按原有空间的2倍扩容，扩容的过程看源码不是很懂，会继续学习。



### 树的递归

树的问题非常适合使用递归的方式解决。在这里最有触动的是覃超老师的递归模板，我在这里再次默写一下：

```java
public void recur(int level, int param) {
		//terminator
		if(level>MAX_levle){
			return;
		}
		
		//process
		process(level,param);
		
		//drill down
		recur(level+1, newparam);
		
		//restore current state
	
}
```



看到一些懵逼的题怎么办，先写出来，调节代码，强行将自己代入递归的节奏中进行思维。多写了几个树递归的问题后，发现人肉递归的问题还是存在，但是可以写出通过递归按层计算的代码，还是需要多练习。

