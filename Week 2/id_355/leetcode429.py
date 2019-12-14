class Solution(object):
    def levelOrder(self, root):
        if not root: return []
        res = []
        self.dfs(root, 0, res)
        return res

    def dfs(self, node, level, res):
        if node:
            if len(res) < level + 1:
                res.append([])
            res[level].append(node.val)
            for e in node.children:
                self.dfs(e, level + 1, res)