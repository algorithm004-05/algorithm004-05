# 第一遍
# 直接使用递归方法：自顶向下；具有自相似性的部分是左子树的上限是当前值，右子树的下限是当前值，根结点无下限无上限
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def helper(root, lower, upper):
            # terminator
            if not root:
                return True
            # process current logic 
            # drill down
            if root.val > lower and root.val < upper:
                return helper(root.left, lower, root.val) and helper(root.right, root.val, upper)
            else:
                return False
            
        return helper(root, float('-inf'), float('inf'))