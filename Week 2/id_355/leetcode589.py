class Solution(object):
    def preorder(self, root):
        if not root: return []
        res = []
        self.dfs(root, res)
        return res

    def dfs(self, node, res):
        if node:
            res.append(node.val)
            for e in node.children:
                self.dfs(e, res)