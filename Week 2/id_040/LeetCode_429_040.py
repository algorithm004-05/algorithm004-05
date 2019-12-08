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
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: Node) -> list:
        if not root:
            return []

        rdata = []
        queue = [(0, root)]
        while queue:
            level, node = queue.pop(0)
            if len(rdata) == level:
                rdata.append([node.val])
            else:
                rdata[level].append(node.val)
            if node.children:
                for i in node.children:
                    queue.append((level + 1, i))
        return rdata


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    root = Node(1, [])
    r3 = Node(3, [])
    r2 = Node(2, [])
    r4 = Node(4, [])
    r5 = Node(5, [])
    r6 = Node(6, [])

    root.children = [r3, r2, r4]
    r3.children = [r5, r6]

    s = Solution()
    print(s.levelOrder(root))
