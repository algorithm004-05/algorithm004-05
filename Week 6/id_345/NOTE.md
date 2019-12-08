# 字典树和并查集

## 字典树（Trie）

Trie模板（Java）
```java
public class Trie {

    private Node root = new Node();

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] cs = word.toCharArray();
        Node node = root;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (!node.containsKey(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setEnd(true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] cs = word.toCharArray();
        Node node = root;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return false;
            }
        }
        return node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] cs = prefix.toCharArray();
        Node node = root;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
    
    static class Node {
        private static final int SIZE = 26;

        private Node[] dict = new Node[SIZE];

        boolean end;

        private boolean containsKey(char c) {
            return dict[c - 'a'] != null;
        }

        private void put(char c, Node node) {
            dict[c - 'a'] = node;
        }

        private Node get(char c) {
            return dict[c - 'a'];
        }

        private void setEnd(boolean isEnd) {
            this.end = isEnd;
        }

        private boolean isEnd() {
            return end;
        }
    }
}
```
Trie模板（Python）
```python
class Trie(object):
  
	def __init__(self): 
		self.root = {} 
		self.end_of_word = "#" 
 
	def insert(self, word): 
		node = self.root 
		for char in word: 
			node = node.setdefault(char, {}) 
		node[self.end_of_word] = self.end_of_word 
 
	def search(self, word): 
		node = self.root 
		for char in word: 
			if char not in node: 
				return False 
			node = node[char] 
		return self.end_of_word in node 
 
	def startsWith(self, prefix): 
		node = self.root 
		for char in prefix: 
			if char not in node: 
				return False 
			node = node[char] 
		return True
```

### 字典树的数据结构 

> 字典树，即 Trie 树，又称单词 查找树或键树，是一种树形结 构。典型应用是用于统计和排 序大量的字符串(但不仅限于 字符串)，所以经常被搜索引 擎系统用于文本词频统计。

> 它的优点是:最大限度地减少 无谓的字符串比较，查询效率 比哈希表高。

2. 字典树的核心思想 

Trie 树的核心思想是空间换时间。 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

3. 字典树的基本性质

    1. 结点本身不存完整单词;
    2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的 字符串;
    3. 每个结点的所有子结点路径代表的字符都不相同。

## 并查集（Disjoint Set）

###  基本操作

* makeSet(s):建立一个新的并查集，其中包含 s 个单元素集合。
* unionSet(x, y):把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在
的集合不相交，如果相交则不合并。
* find(x):找到元素 x 所在的集合的代表，该操作也可以用于判断两个元 素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。

1. 初始化

将每个项的父指向自身

2. 查询、合并
3. 路径压缩

Java 模板
```Java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```

Python 模板
```Python
def init(p): 
	# for i = 0 .. n: p[i] = i; 
	p = [i for i in range(n)] 
 
def union(self, p, i, j): 
	p1 = self.parent(p, i) 
	p2 = self.parent(p, j) 
	p[p1] = p2 
 
def parent(self, p, i): 
	root = i 
	while p[root] != root: 
		root = p[root] 
	while p[i] != i: # 路径压缩 ?
		x = i; i = p[i]; p[x] = root 
	return root
```

# 高级搜索

常用五大算法：
* 分治
* 贪心
* 动态规划（动态递推）
* 回溯
* 分支限界

### 初级搜索

1. 朴素搜索
2. 优化方式:不重复(fibonacci)、剪枝(生成括号问题)
3. 搜索方向:

DFS: depth first search 深度优先搜索 (使用了栈的理念)

BFS: breadth first search 广度优先搜索 (使用了队列的理念)

双向(BFS)搜索、启发式搜索

## 剪枝

DFS 代码模板

递归写法
```python
visited = set() 

def dfs(node, visited):
if node in visited: # terminator
	# already visited 
	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if not next_node in visited: 
			dfs(next_node, visited)
```

非递归写法
```python
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing wor
```

###  回溯法

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当 它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚 至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。
回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况: 

* 找到一个可能存在的正确的答案
* 在尝试了所有可能的分步方法后宣告该问题没有答案 在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

## 双向BFS

BFS 代码模板

```pyton
def BFS(graph, start, end):

	queue = [] 
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```

[AlphaZero扩展资料](https://nikcheerla.github.io/deeplearningschool/2018/01/01/AlphaZero-Explained/)

[棋类复杂度扩展资料](https://en.wikipedia.org/wiki/Game_complexity)




## 启发式搜索

### 一些重要的概念
* 启发式信息：用于帮助减少搜索量的与问题有关的信息或知识。

* 启发式搜索：使用启发信息指导的搜索过程叫做启发式搜索。

* 估价函数：定义在状态空间上的实值函数。

* open表：未扩展的节点

* close表：已扩展或正在扩展的节点

也叫 A*算法

A*代码模板
```python
def AstarSearch(graph, start, end):

	pq = collections.priority_queue() # 优先级 —> 估价函数
	pq.append([start]) 
	visited.add(start)

	while pq: 
		node = pq.pop() # can we add more intelligence here ?
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
   unvisited = [node for node in nodes if node not in visited]
		pq.push(unvisited)
```

扩展资料：

[相似度测量方法](https://dataaspirant.com/2015/04/11/five-most-popular-similarity-measures-implementation-in-python/)

[二进制矩阵中的最短路径的 A* 解法](https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/313347/A*-search-in-Python)

[8 puzzles 解法比较](https://zxi.mytechroad.com/blog/searching/8-puzzles-bidirectional-astar-vs-bidirectional-bfs/)  ———— (花花酱)

[A*算法/博弈树](https://www.cnblogs.com/coder2012/p/3165301.html)

# AVL树和红黑树

###  二叉树遍历

Pre-order/In-order/Post-order

1. 前序(Pre-order):根-左-右 
2. 中序(In-order):左-根-右
3. 后序(Post-order):左-右-根

### Binary Search Tree 二叉搜索树

二叉搜索树，也称二叉搜索树、有序二叉树(Ordered Binary Tree)、 排序二叉树(Sorted Binary Tree)，是指一棵空树或者具有下列性质的 二叉树:
1. 左子树上所有结点的值均小于它的根结点的值;
2. 右子树上所有结点的值均大于它的根结点的值;
3. 以此类推:左、右子树也分别为二叉查找树。 (这就是 重复性!)

中序遍历:升序排列

二叉搜索树极端情况可能会变成链表

#### 保证性能的关键
1. 保证二维维度! —> 左右子树结点平衡(recursively)
2. Balanced
3. [平衡树](https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree)

##  AVL 树

1. 发明者 G. M. Adelson-Velsky 和 Evgenii Landis
2. Balance Factor(平衡因子): 是它的左子树的高度减去它的右子树的高度(有时相反)。 balance factor = {-1, 0, 1}
3. 通过旋转操作来进行平衡(四种)（左旋，右旋，左右旋，右左旋）
4. [平衡树](https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree)

### AVL 总结

1. 平衡二叉搜索树
2. 每个结点存 balance factor = {-1, 0, 1} 
3. 四种旋转操作

不足:结点需要存储额外信息、且调整次数频繁

##  红黑树 Red-black Tree

红黑树是一种近似平衡的二叉搜索树(Binary Search Tree)，它能够确保任何一 个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜 索树:
* 每个结点要么是红色，要么是黑色
* 根节点是黑色
* 每个叶节点(NIL节点，空节点)是黑色的。
* 不能有相邻接的两个红色节点
* 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。

### 关键性质
从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。

## AVL树和红黑树 对比

* AVL trees provide <font color='red'>faster lookups</font> than Red Black Trees because they are <font color='red'>more strictly balanced</font>.
* Red Black Trees provide <font color='red'>faster insertion and removal</font> operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.
* AVL trees store balance <font color='red'>factors or heights</font> with each node, thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.
* Red Black Trees are used in most of the <font color='red'>language libraries like map, multimap, multisetin C++</font> whereas AVL trees are used in <font color='red'>databases</font> where faster retrievals are required.