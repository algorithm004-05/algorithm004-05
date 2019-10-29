# 第一遍
# 递归法
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        def helper(root):
            # terminator
            if not root:
                return 
            # process current logic 左右子结点互换
            root.right, root.left = root.left, root.right
            # drill down
            helper(root.left)
            helper(root.right)
        
        helper(root)
        return root