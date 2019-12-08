# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.ans = None

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.recursion(root, p, q)
        return self.ans

    def recursion(self, root, p, q):
        if not root:
            return False
        left = self.recursion(root.left, p, q)
        right = self.recursion(root.right, p, q)
        mid = (root == p or root == q)
        if left + right + mid >= 2:
            self.ans = root
        return left + right + mid > 0
