# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res_lst = []
        def preorder(node):
            if node:
                res_lst.append(node.val)
                preorder(node.left)
                preorder(node.right)
            return
        preorder(root)
        return res_lst