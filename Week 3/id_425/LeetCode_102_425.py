#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层次遍历
#
# https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
#
# algorithms
# Medium (59.09%)
# Likes:    298
# Dislikes: 0
# Total Accepted:    53.5K
# Total Submissions: 90.1K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
# 
# 例如:
# 给定二叉树: [3,9,20,null,null,15,7],
# 
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
# 
# 
# 返回其层次遍历结果：
# 
# [
# ⁠ [3],
# ⁠ [9,20],
# ⁠ [15,7]
# ]
# 
# 
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# DFS
# class Solution:
#     def levelOrder(self, root: TreeNode) -> List[List[int]]:
#         levels = []
#         if not root:
#             return levels
#         def helper(node,level):
#             # 深度优先遍历可以方便的记录层数，即每次递归即为一层。
#             # 不是每次调用递归函数即加一层，而是，在当前层调用递归函数即加一层，即使调用多次递归函数均在每个函数中加一层
#             # 因此，需要在每个递归函数中添加参数，记录层数。全局变量不行，递归函数存在穿插层数的调用。故只能用参数传递，记录层数
#             if len(levels) == level:
#                 levels.append([])
#             levels[level].append(node.val)
#             if node.left:
#                 helper(node.left,level+1)
#             if node.right:
#                 helper(node.right,level+1)
#             # 无返回值，无结束条件，只在满足条件时执行操作，不满足条件不处理。
#         helper(root,0)
#         return levels

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        levels = []
        if not root:
            return levels
        queue=[root]
        while len(queue)>0:
            nodes = queue
            queue = []
            level = []
            for n in nodes:# i不是TreeNode对象？
                level.append(n.val)
                if n.left!=None:
                    queue.append(n.left)
                if n.right!=None:
                    queue.append(n.right)
                 
            levels.append(level)
        return levels



# @lc code=end

