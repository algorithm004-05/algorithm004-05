# NOTE

  

# 数据结构
如果在某个数据结构中，某一个节点指向了多个后续节点，则该数据结构称为树形结构，即Tree（树）。
从以上描述的特性来讲，Linked List 是特殊化的 Tree，Tree 是特殊化的 Graph。
有环的Tree称为Graph（图）。

# 二叉树

遍历方式有三种：

1. 前序（Pre-order） ： 根-左-右
2. 中序（In-order） ： 左-根-右
3. 后序（Post-order） ： 左-右-根

[二叉搜索树动画DEMO](https://visualgo.net/zh/bst)

##  二叉搜索树 Binary Search Tree

二叉搜索树，也称二叉搜索树、有序二叉树(Ordered Binary Tree)、 排序二叉树(Sorted Binary Tree)，是指一棵空树或者具有下列性质的 二叉树:

1. 左子树上`所有结点`的值均小于它的根结点的值;
2. 右子树上`所有结点`的值均大于它的根结点的值;
3. 以此类推:左、右子树也分别为二叉查找树。 (这就是 重复性!)

中序遍历:升序排列

复杂度分析： https://www.bigocheatsheet.com/

## 递归（Recursion）

`分治`和`回溯`都属于递归，是递归的细分类。

### 思维要点
1. 不要人肉进行递归(最大误区)
2. 找到最近最简方法，将其拆解成可重复解决的问题(重复子问题) 
3. 数学归纳法思维

java递归实现的模板
```java
public void recur(int level, int param) {
     // terminator
    if (level > MAX_LEVEL) {
    // process result
    return; }
    // process current logic
    process(level, param);
    // drill down
    recur( level: level + 1, newParam);
    // restore current status
}
```
## 分治

属于递归，是递归的细分类

```python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 

  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```

```java
public void divideConquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 

  # prepare data 
  data = prepareData(problem) 
  subproblems = splitProblem(problem, data) 

  # conquer subproblems 
  subresult1 = divideConquer(subproblems[0], p1, ...) 
  subresult2 = divideConquer(subproblems[1], p1, ...) 
  subresult3 = divideConquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result 
  result = processResult(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```

## 回溯

属于递归，是递归的细分类


附录：

1. 解决复杂问题，通过寻找重复性来思考解决办法；寻找`最近重复性`，则会联想到分治、回溯等，寻找`最优重复性`，则会联想到动态规划。