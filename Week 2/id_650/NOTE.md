# 第二周总结

做题四件套

1. clarification
2. possible solutions --> optimal (time & space)
3. code
4. test cases

## 树

> 它是由n（n>0）个有限节点组成一个具有层次关系的集合。
特点:

* 每个节点都只有有限个子节点或无子节点；
* 没有父节点的节点称为根节点；
* 每一个非根节点有且只有一个父节点；
* 除了根节点外，每个子节点可以分为多个不相交的子树；
* 树里面没有环路(cycle)
  
## 递归模板流程

1. recursion terminator
2. process logic in current level
3. drill down
4. reverse the current level status if needed

本周的内容有点多，分治和回溯理解较差，练习比较少。通过练习Pow(x,n)这一题，对于分治的认知更加深刻一些，不过距离举一反三灵活运用上还差些距离。
对二叉树的遍历之前有些懵，这次通过老师给的模板，加上练习，对于二叉树感觉进步了很多。

二叉树遍历方式

1. 前序（Pre-order）：根左右
2. 中序（In-order）：左根右
3. 后序（Post-order）：左右根

刚看到这三个方式有些困惑，为什么“前中后”序不是对应“左根右”序，后面就记住前中后都是对于**根**来说的，所以这样一看就很简单了。这三种遍历方式也就是把对根那一步操作放到前中后这么简单。
