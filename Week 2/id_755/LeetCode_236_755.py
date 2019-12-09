# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        lca = {"lca":None}
        def preorder(p, q, node):
            if node is None:
                return 0
            left, right, curr = 0, 0, 0
            if node.val == q.val or node.val == p.val:
                curr = 1
            left = preorder(p, q, node.left)
            right = preorder(p, q, node.right)
            if left + right + curr == 2:
                lca["lca"] = node
                return 0
            return left + right + curr
        preorder(p, q, root)
        return lca["lca"]