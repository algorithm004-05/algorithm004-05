## 589. N叉树的前序遍历

# 递归
# class Solution:
#     def __init__(self):
#         self.arr = []
#     def preorder(self, root: 'Node') -> List[int]:
#         if not root: return []
#         curr = root
#         self.arr.append(root.val)
#         for child in curr.children:
#             self.preorder(child)
#         return self.arr


# 栈 迭代
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if not root: return []
        stack = [root]
        arr = []
        while stack:
            curr = stack.pop()
            arr.append(curr.val)
            for child in curr.children[::-1]:
                stack.append(child)
        return arr