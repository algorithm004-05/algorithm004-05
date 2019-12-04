# 二叉树的中序遍历
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 第一遍：递归实现
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        # 实现中序遍历函数
        def helper(root):
            if not root:
                return 
            helper(root.left)
            res.append(root.val)
            helper(root.right)
        helper(root)
        return res

# 第二遍：调用栈
