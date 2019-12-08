# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
"""
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
"""
from typing import List


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


class Solution:
    # 方法1：递归
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []

        def traversal(root):
            if not root:
                return
            if root.left:
                traversal(root.left)
            res.append(root.val)
            if root.right:
                traversal(root.right)
        traversal(root)
        print("test")
        return res
