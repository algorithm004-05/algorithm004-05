# @author:leacoder
# @des: 递归 二叉树的前序遍历


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        self.helper(root,result)
        return result

    def helper(self,root,result):
        if not root:
            return
        result.append(root.val)
        self.helper(root.left,result)
        self.helper(root.right,result)


# @author:leacoder
# @des: 迭代 + 借助栈 二叉树的前序遍历

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result, stack = [], [root]
        while stack:
            root = stack.pop()
            if root is not None:
                result.append(root.val)
                if root.right is not None: # 由于 栈先进后出，所以前序遍历 先压入 right
                    stack.append(root.right)
                if root.left is not None:
                    stack.append(root.left)
        return result       



