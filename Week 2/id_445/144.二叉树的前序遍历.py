#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # solution 1 recursively
    # def preorderTraversal(self, root: TreeNode) -> List[int]:
    #     res=[]
    #     self.recur(root,res)
    #     return res
    # def recur(self,node,res):
    #     if not node:
    #         return
    #     res.append(node.val)
    #     self.recur(node.left,res)
    #     self.recur(node.right,res)
    # solution 2 iteratively
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res,stack=[],[]
        while True:
            while  root:
                res.append(root.val)
                stack.append(root)
                root=root.left
            if not stack:
                return res
            root=stack.pop().right
            

        
# @lc code=end

