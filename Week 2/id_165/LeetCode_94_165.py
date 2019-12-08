# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# class Solution(object):
#
#     def __init__(self):
#
#         self.res = []
#
#     def inorderTraversal(self, root):
#         """
#         :type root: TreeNode
#         :rtype: List[int]
#         """
#
#         if root.left:
#             self.inorderTraversal(root.left)
#
#         self.res.append(root.val)
#
#         if root.right:
#             self.inorderTraversal(root.right)


class Solution(object):

    def __init__(self):

        self.res = []
        self.stack = []

    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        current = root
        while current and self.stack:

            if current:
                self.stack.append(current)
                current = current.left

            else:
                s = self.stack.pop()
                self.res.append(s)
                current = current.right

        return self.res

