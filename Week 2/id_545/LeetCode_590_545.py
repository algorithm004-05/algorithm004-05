## 590. N叉树的后序遍历

# 递归
class Solution:
    def __init__(self):
        self.arr = []
    def postorder(self, root: 'Node') -> List[int]:
        if root:
            for i in range(len(root.children)):
                self.postorder(root.children[i])
            self.arr.append(root.val)
        return self.arr

# 栈 迭代法
# class Solution:
#     def postorder(self, root: 'Node') -> List[int]:
#         if not root: return []
#         stack = [root]
#         arr = []
#         while stack:
#             tmp = stack.pop()
#             arr.append(tmp.val)
#             if tmp.children:
#                 for i in tmp.children:
#                     stack.append(i)
#         return arr[::-1]