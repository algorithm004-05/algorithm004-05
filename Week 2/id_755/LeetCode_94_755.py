# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res_lst = []
        def inorder(node):
            if node:
                inorder(node.left)
                res_lst.append(node.val)
                inorder(node.right)
            return
        inorder(root)
        return res_lst