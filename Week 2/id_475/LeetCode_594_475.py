# 第一遍
# 递归实现N叉树，方法和二叉的一样，关键是root.children是一个list
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        res = []
        def helper(root):
            if not root:
                return
            for children in root.children:
                helper(children)
            res.append(root.val)
        helper(root)
        return res

# 第二遍
# 迭代