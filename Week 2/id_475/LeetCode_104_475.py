# 二叉树的最大深度
# 第一遍
# 递归法：重复的部分是当前结点+1，返回左右子树的最大深度
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        def helper(root):
            # terminator
            if not root:
                return 0
            # process current logic
            # drill down
            return max(helper(root.left), helper(root.right)) + 1
        
        return helper(root)

# 对比二叉树的最小深度
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        if not root.left:
            return self.minDepth(root.right)+1
        if not root.right:
            return self.minDepth(root.left)+1
        return min(self.minDepth(root.left),self.minDepth(root.right))+1
