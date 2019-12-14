#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
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
    # def inorderTraversal(self, root: TreeNode) -> List[int]:
    #     res=[]
    #     self.recur(root,res)
    #     return res
    # def recur(self,node,res):
    #     if node:
    #         self.recur(node.left,res)
    #         res.append(node.val)
    #         self.recur(node.right,res)
    # solution 2 iteratively
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res,stack=[],[]
        while True:
            while root:
                stack.append(root)
                root=root.left
            if not stack:
                return res
            node=stack.pop()
            res.append(node.val)
            root=node.right
        # return res

        
# @lc code=end

