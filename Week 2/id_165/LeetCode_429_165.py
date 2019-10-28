# 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
#
# 例如，给定一个 3叉树 :
#
#
#
#
#
#
#
# 返回其层序遍历:
#
# [
#     [1],
#     [3,2,4],
#     [5,6]
# ]
#
#
#
#
# 说明:
#
#
# 树的深度不会超过 1000。
# 树的节点总数不会超过 5000。
# Related Topics 树 广度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)

# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution(object):

    def __init__(self):

        self.result = []

    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if root:
            self.visit([root], 1)

        return self.result

    def visit(self, nodes, lvl):

        if len(self.result) < lvl:
            self.result.append([])

        for n in nodes:
            self.result[lvl - 1].append(n.val)

        for n in nodes:
            if n.children:
                self.visit(n.children, lvl + 1)

# leetcode submit region end(Prohibit modification and deletion)
