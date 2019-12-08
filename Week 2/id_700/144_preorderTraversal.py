# 给定一个二叉树，返回它的 前序 遍历。

###   前序遍历  根 - 左 - 右

Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.preorder(self,res)
        return res
    def preorder(self,root,res):
        if root:
            res.append（root.val,res)
            preorder.left(root.left,res)
            preorder.right(root.right,res)
