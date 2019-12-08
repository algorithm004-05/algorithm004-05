#
# @lc app=leetcode.cn id=104 lang=python3
#
# [104] 二叉树的最大深度
#
# https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
#
# algorithms
# Easy (71.09%)
# Likes:    367
# Dislikes: 0
# Total Accepted:    87.7K
# Total Submissions: 123.2K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个二叉树，找出其最大深度。
# 
# 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
# 
# 说明: 叶子节点是指没有子节点的节点。
# 
# 示例：
# 给定二叉树 [3,9,20,null,null,15,7]，
# 
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
# 
# 返回它的最大深度 3 。
# 
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        depth = 1
        return (self.numDepth(root,depth))
    def numDepth(self,root,depth):
        if root==None:
            return depth-1
        lmaxDepth = self.numDepth(root.left,depth+1)
        rmaxDepth = self.numDepth(root.right,depth+1)
        return lmaxDepth if(lmaxDepth>=rmaxDepth) else rmaxDepth
# @lc code=end

