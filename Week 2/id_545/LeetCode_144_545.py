## 144. 二叉树的前序遍历

# 递归
# class Solution:
#     def __init__(self):
#         self.arr = []
        
#     def preorderTraversal(self, root: TreeNode) -> List[int]:
#         if root:
#             self.arr.append(root.val)
#             self.preorderTraversal(root.left)
#             self.preorderTraversal(root.right)
        
#         return self.arr


# 迭代法
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        arr = []
        stack = []
        curr = root
        while curr or stack:
            if curr:
                arr.append(curr.val)
                stack.append(curr)
                curr = curr.left
            else:
                curr = stack.pop()
                curr = curr.right
                
        return arr