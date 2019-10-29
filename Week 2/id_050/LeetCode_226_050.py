# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.helper(root)
        return root
    def helper(self, root):
        # recursion terminator
        if root is None:
            return
        # process logic of this level
        root.left, root.right = root.right, root.left
        # drill down
        if root.left:
            self.helper(root.left)
        if root.right:
            self.helper(root.right)
        # reverse state if needed
