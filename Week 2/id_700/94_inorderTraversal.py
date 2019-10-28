####  中序遍历——   左  ——  根 —— 右


#####   Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.inorder(root, res)
        return res
    def inorder(self,root,res):
        if root:
            self.inorder(root.left,res)
            res.append(root.val)
            self.inorder(root.right,res)




####   学习国际站别人的写法，列表与堆的方式
# iteratively
def inorderTraversal(self, root):
    res, stack = [], []
    while True:
        while root:
            stack.append(root)
            root = root.left
        if not stack:
            return res
        node = stack.pop()
        res.append(node.val)
        root = node.right