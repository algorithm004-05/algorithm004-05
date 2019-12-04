from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(inorder) == 0:
            return None
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        # 当 mid 的位置为中序遍历中根节点的位置时，根据前序遍历的特性（根-> 左 -> 右），以及中序遍历的特性（左 -> 根 -> 右）。
        # 在前序遍历中，左子树的节点数量为mid个，即为：preorder[1:mid + 1]。
        # 在中序遍历中，左子树的节点即为：inorder[:mid]
        # 反之则是右子树的位置。
        root.left = self.buildTree(preorder[1:mid + 1], inorder[:mid])
        root.right = self.buildTree(preorder[mid + 1:], inorder[mid + 1:])
        return root
