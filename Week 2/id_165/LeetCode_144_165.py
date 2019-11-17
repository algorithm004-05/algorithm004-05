# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def __init__(self):
        self.res = []

    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        if root:
            self.res.append(root.val)

            if root.left:
                self.preorderTraversal(root.left)

            if root.right:
                self.preorderTraversal(root.right)

        return self.res

