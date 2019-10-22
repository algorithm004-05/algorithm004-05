## 概念



### 数组



### 链表



### 跳表


### 栈 stack

后进先出，添加、删除均为 O(1)

### 队列 Queue

先入先出，添加、删除均为 O(1)


### 双端队列 Deque

插入、删除 O1

### 优先队列

插入O1，取出 O(logN)，按照元素的优先级取出

底层具体实现的数据结构较为多样和复杂：heap、bst、treap...



## 技巧

### 解题技巧

由简至繁的解题思路：

暴力穷举——> 化繁为简

​		——> 泛化：找最近重复子问题 (if else，for while， recursion) ——> 组合

​		——> 左右边界，中间收敛——左右夹逼

​		——> 高级数据结构

对比别人的解法与思路，对于之前完全没思路的好想法，要重复、熟悉，转化成自己的东西



### 面试技巧

代码尽量简洁，注意代码风格，注意与面试官的沟通交流（包括审题、思路等）

### 五毒神掌（五遍刷题法）

...

### 解题步骤
1. 5-10分钟：读题与思考
2. 有思路：开始尝试写代码，否则看题解
3. 默写背诵，熟练
4. 闭卷写

其中，在步骤2时把**所有**的思路都写出来，最后再进行对比，不需要考虑是否为优化解。

最后需要考虑代码的精简度

#### 个人

- 开源例子学习
- 最后闭卷手写代码
- 可以把所有的思路和对比、复杂度罗列
- 有意识地构思题目变种：如两数之和到三数之和



课后作业 连接

https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

https://leetcode-cn.com/problems/rotate-array/

https://leetcode-cn.com/problems/merge-two-sorted-lists/

https://leetcode-cn.com/problems/merge-sorted-array/

https://leetcode-cn.com/problems/two-sum/

https://leetcode-cn.com/problems/move-zeroes/

https://leetcode-cn.com/problems/plus-one/



追加

用 add first 或 add last 这套新的 API 改写 Deque 的代码

分析 Queue 和 Priority Queue 的源码

https://leetcode.com/problems/design-circular-deque

https://leetcode.com/problems/trapping-rain-water/