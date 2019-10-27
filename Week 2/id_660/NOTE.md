## 概念

### 哈希表 (散列表)

通过哈希函数来把关键码值映射到哈希表中的位置来访问记录。查询速度较快，为 O1；

```java
// 一种哈希函数实现示例，其中 tableSize 越大，哈希碰撞概率越小
public static int hash(String key, int tableSize) {
  int hashVal = 0;
  for (int i = 0; i < key.length(); i++) {
    hashVal = 37 * hashVal + key.charAt(i); 
  }
  hashVal %= tableSize
    if (hashVal < 0)
      hashVal += tableSize;
  return hashVal;
}
```

在哈希碰撞时，再增加一个纬度，用链表存储。这种解决哈希冲突的方式叫拉链式解决冲突法。如果碰撞次数较多，最快情况时间复杂度将会接近 On；

#### Map 与 Set 的区别：

Map 为 key-value 对，key 不重复。Set 为不重复元素的集合。根据具体实现，时间复杂度存在区别。

 Java 中，HashSet 的实现是基于 HashMap 的，而且存在空间浪费的情况。

 #### HashMap的实现
 Java8中采用数组+链表+红黑树的方式对元素进行存储，这样安全和功能性完备的情况下让其速度更快，同时减少了哈希冲突的情况。HashMap的主结构类似于一个数组,添加值时通过key确定储存位置.每个位置是一个Node的数据结构,该结构可组成链表.当发生冲突时,相同hash值的键值对会组成链表.


### 树

#### 基础概念

二维结构，比一维结构（链表）多一层指向。

了解了根，叶子， 父节点，根节点，高度，深度，层级等概念；

与图的差别，节点是否存在环。

#### 树的遍历 

1.前序（Pre-order）：根-左-右

2.中序（In-order）：左-根-右

3.后序（Post-order）：左-右-根

```
void preOrder(Node* root) {
  if (root == null) return;
  print root // 此处为伪代码，表示打印root节点
  preOrder(root->left);
  preOrder(root->right);
}

void inOrder(Node* root) {
  if (root == null) return;
  inOrder(root->left);
  print root // 此处为伪代码，表示打印root节点
  inOrder(root->right);
}

void postOrder(Node* root) {
  if (root == null) return;
  postOrder(root->left);
  postOrder(root->right);
  print root // 此处为伪代码，表示打印root节点
}
```



#### 扩展

二叉树：只有两个子节点的树。

二叉搜索树，在二叉树基础上进行规则约束的一种扩展树，满足以下条件：

1. 左子树上所有结点的值均小于它的根结点的值；
2. 右子树上所有结点的值均大于它的根结点的值；
3. 以此类推：左、右子树也分别为二叉查找树。
4. 空树也是一种二叉搜索树

```java
// 查找
public class BinarySearchTree {
  private Node tree;

  public Node find(int data) {
    Node p = tree;
    while (p != null) {
      if (data < p.data) p = p.left;
      else if (data > p.data) p = p.right;
      else return p;
    }
    return null;
  }

  public static class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
      this.data = data;
    }
  }
}
```

```java
// 插入操作
public void insert(int data) {
  if (tree == null) {
    tree = new Node(data);
    return;
  }

  Node p = tree;
  while (p != null) {
    if (data > p.data) {
      if (p.right == null) {
        p.right = new Node(data);
        return;
      }
      p = p.right;
    } else { // data < p.data
      if (p.left == null) {
        p.left = new Node(data);
        return;
      }
      p = p.left;
    }
  }
}
```

```java
// 删除操作
public void delete(int data) {
  Node p = tree; // p指向要删除的节点，初始化指向根节点
  Node pp = null; // pp记录的是p的父节点
  while (p != null && p.data != data) {
    pp = p;
    if (data > p.data) p = p.right;
    else p = p.left;
  }
  if (p == null) return; // 没有找到

  // 要删除的节点有两个子节点
  if (p.left != null && p.right != null) { // 查找右子树中最小节点
    Node minP = p.right;
    Node minPP = p; // minPP表示minP的父节点
    while (minP.left != null) {
      minPP = minP;
      minP = minP.left;
    }
    p.data = minP.data; // 将minP的数据替换到p中
    p = minP; // 下面就变成了删除minP了
    pp = minPP;
  }

  // 删除节点是叶子节点或者仅有一个子节点
  Node child; // p的子节点
  if (p.left != null) child = p.left;
  else if (p.right != null) child = p.right;
  else child = null;

  if (pp == null) tree = child; // 删除的是根节点
  else if (pp.left == p) pp.left = child;
  else pp.right = child;
}
```



![https://www.bigocheatsheet.com](/Users/budy/Pictures/markdown_pic/Attachment-2186205.png)





### 泛型递归，树的递归

问题：树的面试题解法一般都是递归，为什么？

答：区别在于节点的定义、与重复性（自相似性）。

> 递归代码也有很多弊端。比如，堆栈溢出、重复计算、函数调用耗时多、空间复杂度高等，所以，在编写递归代码的时候，一定要控制好这些副作用。

#### 递归四步走

1. 递归终结条件
2. 处理当前层的逻辑
3. 下探到下一层
4. 清理当前层（如果有的话，如全局变量）

```java
// java example
public void recur(int level, int param) {
  // terminator
  if (level > MAX_LEVEL) {
    // process result
    return;
  }
  
  // process current logic
  process(level, param);
    
  // drill down
  recur(level: level +1, newParam);
  
  // restore current status
}
```

#### 思维要点

1. 不要人肉进行递归（最大误区）

2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）

3. 数学归纳法思维

### 分治、回溯

#### 分治算法

分治算法的核心思想就是将原问题划分成 n 个规模较小，并且结构与原问题相似的子问题，递归地解决这些子问题，然后再合并其结果，就得到原问题的解。

关于分治和递归的区别，

分治算法是一种处理问题的思想，递归是一种编程技巧。实际上，分治算法一般都比较适合用递归来实现。

分治算法的递归实现中，每一层递归都会涉及这样三个操作：

- 分解：将原问题分解成一系列子问题；
- 解决：递归地求解各个子问题，若子问题足够小，则直接求解；
- 合并：将子问题的结果合并成原问题。

分治算法能解决的问题，一般需要满足下面这几个条件：

- 原问题与分解成的小问题具有相同的模式；
- 原问题分解成的子问题可以独立求解，子问题之间没有相关性，这一点是分治算法跟动态规划的明显区别；
- 具有分解终止条件，也就是说，当问题足够小时，可以直接求解；可以将子问题合并成原问题，而这个合并操作的复杂度不能太高，否则就起不到减小算法总体复杂度的效果了。

#### 回溯

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程 中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将 取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问 题的答案。

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种 情况：

- 找到一个可能存在的正确的答案；

- 在尝试了所有可能的分步方法后宣告该问题没有答案。

  > 在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

