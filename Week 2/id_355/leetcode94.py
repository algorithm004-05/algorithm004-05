class Solution(object):
    def inorderTraversal(self, root):
        if not root: return []
        self.res = []
        self.dfs(root)
        return self.res

    def dfs(self, root):
        if root:
            self.dfs(root.left)
            self.res.append(root.val)
            self.dfs(root.right)