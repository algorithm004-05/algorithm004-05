## 94.二叉树的中序遍历

# 迭代法
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if not root: return []
        arr = []
        stack = []
        curr = root
        while curr or stack:
            if curr:
                stack.append(curr)
                curr = curr.left
            else:
                curr = stack.pop()
                arr.append(curr.val)
                curr = curr.right
        return arr

# 递归
# class Solution:
#     def __init__(self):
#         self.arr = []
#     def inorderTraversal(self, root: TreeNode) -> List[int]:
#         if root:
#             self.inorderTraversal(root.left)
#             self.arr.append(root.val)
#             self.inorderTraversal(root.right)
#         return self.arr